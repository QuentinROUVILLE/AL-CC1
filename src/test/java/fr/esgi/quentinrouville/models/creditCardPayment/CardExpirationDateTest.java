package fr.esgi.quentinrouville.models.creditCardPayment;

import fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard.CardExpirationDate;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class CardExpirationDateTest {
    @Test
    public void testCardExpirationDate() {
        final int year = Calendar.getInstance().get(Calendar.YEAR) + 1;
        final int month = Calendar.getInstance().get(Calendar.MONTH);

        final CardExpirationDate cardExpirationDate = CardExpirationDate.of(year, month);
        assertEquals(cardExpirationDate.toString(), LocalDate.of(year, month, 1).toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardExpirationDateWhenTheDateIsInThePast() {
        final int year = Calendar.getInstance().get(Calendar.YEAR) - 1;
        final int month = Calendar.getInstance().get(Calendar.MONTH);

        CardExpirationDate.of(year, month);
    }
}
