package fr.esgi.quentinrouville.user_case.creditCardPayment;

import fr.esgi.quentinrouville.use_case.member.infrastructure.CardSecurityCode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardSecurityCodeTest {
    @Test
    public void testCardSecurityCode() {
        final CardSecurityCode cardSecurityCode = CardSecurityCode.of("123");
        assertEquals("123", cardSecurityCode.toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardSecurityCodeWhenTheNumberIsTooSmall() {
        CardSecurityCode.of("12");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardSecurityCodeWhenTheNumberIsTooLarge() {
        CardSecurityCode.of("1234");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCardSecurityCodeWhenTheNumberIsntAFullNumber() {
        CardSecurityCode.of("ABC");
    }
}
