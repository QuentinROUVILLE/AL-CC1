package fr.esgi.quentinrouville.use_case.member.infrastructure;

import fr.esgi.quentinrouville.use_case.member.application.DateService;

import java.time.LocalDate;
import java.util.Objects;

public final class CardExpirationDate
{
    private final LocalDate expirationDate;

    private final DateService dateService = new DateService();

    private CardExpirationDate(LocalDate expirationDate) {
        if(!expirationDateIsValid(expirationDate)) {
            throw new IllegalArgumentException("Expiration date is not valid");
        }
        this.expirationDate = expirationDate;
    }

    public static CardExpirationDate of(int year, int month) {
        return new CardExpirationDate(LocalDate.of(year, month, 1));
    }

    private boolean expirationDateIsValid(LocalDate expirationDate) {
        return dateService.isDateInTheFuture(expirationDate);
    }

    @Override
    public String toString() {
        return expirationDate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardExpirationDate)) return false;
        CardExpirationDate that = (CardExpirationDate) o;
        return expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationDate);
    }
}
