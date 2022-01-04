package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.CommandHandler;
import fr.esgi.quentinrouville.kernel.Event;
import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.domain.*;

public class CreateMemberCommandHandler implements CommandHandler<CreateMember, MemberId> {
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateMemberCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public MemberId handle(CreateMember createMember) {
        final MemberId memberId = memberRepository.nextIdentity();
        Member member = Member.of(
                memberId,
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
