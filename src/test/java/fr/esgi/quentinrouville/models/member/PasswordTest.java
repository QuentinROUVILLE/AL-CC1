package fr.esgi.quentinrouville.models.member;

import fr.esgi.quentinrouville.common.domain.model.member.Password;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class PasswordTest {
    @Test
    public void testPassword() {
        Password password = Password.of("Azerty123@");
        assertEquals(password.toString(), "Azerty123@");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordWhenPasswordIsEmpty() {
        Password.of("Azerty123");
    }
}
