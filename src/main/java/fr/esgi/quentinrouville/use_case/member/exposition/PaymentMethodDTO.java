package fr.esgi.quentinrouville.use_case.member.exposition;

import fr.esgi.quentinrouville.use_case.member.domain.PaymentMethod;

public class PaymentMethodDTO {
    public final PaymentMethod paymentMethod;

    private PaymentMethodDTO(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static PaymentMethodDTO of(PaymentMethod paymentMethod) {
        return new PaymentMethodDTO(paymentMethod);
    }

    @Override
    public String toString() {
        return "PaymentMethodDTO{" +
                "paymentMethod=" + paymentMethod +
                '}';
    }
}
