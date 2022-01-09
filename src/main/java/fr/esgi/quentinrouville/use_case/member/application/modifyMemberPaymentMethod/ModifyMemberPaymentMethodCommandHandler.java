package fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod;

import fr.esgi.quentinrouville.kernel.CommandHandler;
import fr.esgi.quentinrouville.kernel.Event;
import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.domain.Member;
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
        final Member member = memberRepository.findById(command.memberId);
        final PaymentMethod paymentMethod = command.paymentMethod.paymentMethod;
        member.changePaymentMethod(paymentMethod);
        eventEventDispatcher.dispatch(ModifyMemberPaymentMethodEvent.of(command.memberId));
        return null;
    }
}
