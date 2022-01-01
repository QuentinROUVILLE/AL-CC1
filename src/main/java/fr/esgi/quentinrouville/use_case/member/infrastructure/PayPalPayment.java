package fr.esgi.quentinrouville.use_case.member.infrastructure;

import fr.esgi.quentinrouville.use_case.member.domain.PaymentMethod;

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
    public boolean paymentIsValid() {
        return true;
    }

    @Override
    public String toString()
    {
        return "PayPal token : " + token;
    }
}
