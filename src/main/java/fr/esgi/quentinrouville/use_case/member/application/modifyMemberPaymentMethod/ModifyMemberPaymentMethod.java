package fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod;

import fr.esgi.quentinrouville.kernel.Command;
import fr.esgi.quentinrouville.use_case.member.exposition.PaymentMethodDTO;

import java.util.Objects;

public final class ModifyMemberPaymentMethod implements Command {
    public final int memberId;
    public final PaymentMethodDTO paymentMethod;

    private ModifyMemberPaymentMethod(int memberId, PaymentMethodDTO paymentMethod) {
        this.memberId = Objects.requireNonNull(memberId);
        this.paymentMethod = Objects.requireNonNull(paymentMethod);
    }

    public static ModifyMemberPaymentMethod of(int memberId, PaymentMethodDTO paymentMethod) {
        return new ModifyMemberPaymentMethod(memberId, paymentMethod);
    }
}
