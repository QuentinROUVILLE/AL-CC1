package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.ApplicationEvent;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;

public class ModifyMemberPaymentMethodEvent implements ApplicationEvent {
    private final MemberId memberId;

    private ModifyMemberPaymentMethodEvent(MemberId memberId) {
        this.memberId = memberId;
    }

    public static ModifyMemberPaymentMethodEvent of(MemberId memberId) {
        return new ModifyMemberPaymentMethodEvent(memberId);
    }
}
