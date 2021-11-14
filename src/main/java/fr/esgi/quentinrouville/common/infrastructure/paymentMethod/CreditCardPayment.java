package fr.esgi.quentinrouville.common.infrastructure.paymentMethod;

import fr.esgi.quentinrouville.common.domain.model.PaymentMethod;

public class CreditCardPayment implements PaymentMethod
{
    private final String cardNumber;
    private final String expirationDate;
    private final String securityCode;

    public CreditCardPayment(String cardNumber, String expirationDate, String securityCode)
    {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    @Override
    public boolean PayAmount(double Amount) {
        System.out.println("Paying " + Amount + "€ with " + this);
        return true;
    }

    @Override
    public String toString()
    {
        return "Credit card " + cardNumber + " (" + expirationDate + ") : " + securityCode;
    }
}
