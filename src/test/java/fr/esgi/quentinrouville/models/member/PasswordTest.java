package fr.esgi.quentinrouville.models.member;

import fr.esgi.quentinrouville.use_case.member.domain.model.Password;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class PasswordTest {
    @Test
    public void testPassword() {
        final Password password = Password.of("Azerty123@");
        assertEquals(password.toString(), "Azerty123@");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordWhenPasswordIsEmpty() {
        Password.of("Azerty123");
    }
}
