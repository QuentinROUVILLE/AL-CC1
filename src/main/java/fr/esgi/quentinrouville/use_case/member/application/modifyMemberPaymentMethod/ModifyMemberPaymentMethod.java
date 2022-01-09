package fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod;

import fr.esgi.quentinrouville.kernel.Command;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.exposition.PaymentMethodDTO;

import java.util.Objects;

public final class ModifyMemberPaymentMethod implements Command {
    public final MemberId memberId;
    public final PaymentMethodDTO paymentMethod;

    private ModifyMemberPaymentMethod(MemberId memberId, PaymentMethodDTO paymentMethod) {
        this.memberId = Objects.requireNonNull(memberId);
        this.paymentMethod = Objects.requireNonNull(paymentMethod);
    }

    public static ModifyMemberPaymentMethod of(MemberId memberId, PaymentMethodDTO paymentMethod) {
        return new ModifyMemberPaymentMethod(memberId, paymentMethod);
    }
}
