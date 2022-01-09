package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.CommandHandler;
import fr.esgi.quentinrouville.kernel.Event;
import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.domain.*;

import java.util.Objects;

public class CreateMemberCommandHandler implements CommandHandler<CreateMember, MemberId> {
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    private CreateMemberCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = Objects.requireNonNull(memberRepository);
        this.eventEventDispatcher = Objects.requireNonNull(eventEventDispatcher);
    }

    public static CreateMemberCommandHandler of(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new CreateMemberCommandHandler(memberRepository, eventEventDispatcher);
    }

    public MemberId handle(CreateMember createMember) {
        final MemberId memberId = memberRepository.nextIdentity();
        Member member = Member.of(
                memberId,
                createMember.memberType,
                createMember.lastName,
                createMember.firstName,
                EmailAddress.of(createMember.email.emailAddress),
                Password.of(createMember.password.password)
        );
        memberRepository.save(member);
        eventEventDispatcher.dispatch(CreateMemberEvent.of(memberId));
        return memberId;
    }
}
