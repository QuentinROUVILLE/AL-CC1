package fr.esgi.quentinrouville.models.creditCardPayment;

import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard.CardNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardNumberTest {
    @Test
    public void testCardNumber() {
        CardNumber cardNumber = CardNumber.of("4111111111111111");
        assertEquals("4111111111111111", cardNumber.toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardNumberWhenTheNumberIsTooSmall() {
        CardNumber.of("41");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardNumberWhenTheNumberIsTooLarge() {
        CardNumber.of("4111111111111111444444");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardNumberWhenTheNumberIsntAFullNumber() {
        CardNumber.of("411111111111111A");
    }
}
