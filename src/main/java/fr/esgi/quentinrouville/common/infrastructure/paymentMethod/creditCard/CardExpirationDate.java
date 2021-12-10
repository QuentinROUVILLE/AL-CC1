package fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard;

import fr.esgi.quentinrouville.common.domain.services.DateService;

import java.time.LocalDate;

public final class CardExpirationDate
{
    private final LocalDate expirationDate;

    private final DateService dateService = new DateService();

    private CardExpirationDate(LocalDate expirationDate) {
        if(!ExpirationDateIsValid(expirationDate)) {
            throw new IllegalArgumentException("Expiration date is not valid");
        }
        this.expirationDate = expirationDate;
    }

    public static CardExpirationDate of(int year, int month) {
        return new CardExpirationDate(LocalDate.of(year, month, 1));
    }

    private boolean ExpirationDateIsValid(LocalDate expirationDate) {
        return dateService.isDateInTheFuture(expirationDate);
    }

    @Override
    public String toString() {
        return expirationDate.toString();
    }
}
