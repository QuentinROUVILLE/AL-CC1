package fr.esgi.quentinrouville.common.domain.model;

public interface PaymentMethod
{
    default boolean PayAmount(double Amount)
    {
        if(PaymentIsValid())
        {
            System.out.println("Paying " + Amount + "€ with " + this);

            return true;
        }
        else
        {
            System.out.println("Payment refused");
            return false;
        }
    }

    boolean PaymentIsValid();
}
