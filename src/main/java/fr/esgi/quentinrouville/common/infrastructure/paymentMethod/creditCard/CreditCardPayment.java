package fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard;

import fr.esgi.quentinrouville.common.domain.model.PaymentMethod;

import java.util.Objects;

public final class CreditCardPayment implements PaymentMethod
{
    private final String cardNumber;
    private final String expirationDate;
    private final String securityCode;
    private final String owner;

    private CreditCardPayment(String cardNumber, String expirationDate, String securityCode, String owner)
    {
        this.cardNumber = Objects.requireNonNull(cardNumber);
        this.expirationDate = Objects.requireNonNull(expirationDate);
        this.securityCode = Objects.requireNonNull(securityCode);
        this.owner = Objects.requireNonNull(owner);
    }

    public static CreditCardPayment of(String cardNumber, String expirationDate, String securityCode, String owner)
    {
        return new CreditCardPayment(cardNumber, expirationDate, securityCode, owner);
    }

    @Override
    public boolean PaymentIsValid() {
        return true;
    }

    @Override
    public String toString()
    {
        return "Credit card " + cardNumber + " (" + expirationDate + ") cc " + securityCode + " of " + owner;
    }
}
