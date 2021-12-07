package fr.esgi.quentinrouville.common.infrastructure.paymentMethod;

import fr.esgi.quentinrouville.common.domain.model.PaymentMethod;

public final class PayPalPayment implements PaymentMethod
{
    private final String token;

    private PayPalPayment(String token)
    {
        this.token = token;
    }

    public static PayPalPayment of(String token)
    {
        return new PayPalPayment(token);
    }

    @Override
    public boolean PaymentIsValid() {
        return true;
    }

    @Override
    public String toString()
    {
        return "PayPal token : " + token;
    }
}
