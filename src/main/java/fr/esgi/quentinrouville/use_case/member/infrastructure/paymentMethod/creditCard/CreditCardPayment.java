package fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard;

import fr.esgi.quentinrouville.use_case.member.domain.PaymentMethod;

import java.util.Objects;

public final class CreditCardPayment implements PaymentMethod
{
    private final CardNumber cardNumber;
    private final CardExpirationDate expirationDate;
    private final CardSecurityCode securityCode;
    private final String owner;

    private CreditCardPayment(CardNumber cardNumber, CardExpirationDate expirationDate, CardSecurityCode securityCode, String owner)
    {
        this.cardNumber = Objects.requireNonNull(cardNumber);
        this.expirationDate = Objects.requireNonNull(expirationDate);
        this.securityCode = Objects.requireNonNull(securityCode);
        this.owner = Objects.requireNonNull(owner);
    }

    public static CreditCardPayment of(CardNumber cardNumber, CardExpirationDate expirationDate, CardSecurityCode securityCode, String owner)
    {
        return new CreditCardPayment(cardNumber, expirationDate, securityCode, owner);
    }

    @Override
    public boolean paymentIsValid() {
        return true;
    }

    @Override
    public String toString()
    {
        return "Credit card " + cardNumber + " (" + expirationDate + ") cc " + securityCode + " of " + owner;
    }
}
