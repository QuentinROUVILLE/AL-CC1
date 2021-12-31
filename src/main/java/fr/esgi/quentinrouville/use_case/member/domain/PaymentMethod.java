package fr.esgi.quentinrouville.use_case.member.domain;

public interface PaymentMethod
{
    default boolean payAmount(double Amount)
    {
        if(paymentIsValid())
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

    boolean paymentIsValid();
}
