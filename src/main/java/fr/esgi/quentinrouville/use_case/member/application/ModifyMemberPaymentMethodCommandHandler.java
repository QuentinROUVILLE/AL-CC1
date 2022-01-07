package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.CommandHandler;
import fr.esgi.quentinrouville.kernel.Event;
import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.domain.PaymentMethod;

public final class ModifyMemberPaymentMethodCommandHandler implements CommandHandler<ModifyMemberPaymentMethod, Void> {
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    private ModifyMemberPaymentMethodCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public static ModifyMemberPaymentMethodCommandHandler of(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new ModifyMemberPaymentMethodCommandHandler(memberRepository, eventEventDispatcher);
    }

    public Void handle(ModifyMemberPaymentMethod command) {
        final MemberId memberId = MemberId.of(command.memberId);
        final Member member = memberRepository.findById(memberId);
        final PaymentMethod paymentMethod = (PaymentMethod) command.paymentMethod;
        member.changePaymentMethod(paymentMethod);
        return null;
    }
}
