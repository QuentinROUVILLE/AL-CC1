package fr.esgi.quentinrouville.common.infrastructure.paymentMethod;

import fr.esgi.quentinrouville.common.domain.model.PaymentMethod;

public class PayPalPayment implements PaymentMethod
{
    private final String token;

    public PayPalPayment(String token) {
        this.token = token;
    }

    @Override
    public boolean PayAmount(double Amount) {
        System.out.println("Paying " + Amount + "€ with " + this);
        return true;
    }

    @Override
    public String toString() {
        return "PayPal token : " + token;
    }
}
