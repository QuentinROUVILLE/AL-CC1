package fr.esgi.quentinrouville.models.member;

import fr.esgi.quentinrouville.common.domain.model.member.EmailAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public final class EmailTest {
    @Test
    public void testEmail() {
        EmailAddress email = EmailAddress.of("rouvilleq@gmail.com");
        assertEquals(email.toString(), "rouvilleq@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmailWithWrongEmail() {
        EmailAddress email = EmailAddress.of("rouvilleqgmail.com");
        assertNull(email);
    }
}
