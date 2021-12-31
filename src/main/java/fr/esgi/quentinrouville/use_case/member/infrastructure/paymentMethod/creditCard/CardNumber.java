package fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard;

import java.util.Objects;

public final class CardNumber
{
    private final String number;

    private CardNumber(String number)
    {
        if(!NumberIsValid(number)){
            throw new IllegalArgumentException("Invalid card number");
        }
        this.number = number;
    }

    public static CardNumber of(String number)
    {
        return new CardNumber(number);
    }

    public boolean NumberIsValid(String number)
    {
        return number.matches("^[0-9]{16}$");
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardNumber)) return false;
        CardNumber that = (CardNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
