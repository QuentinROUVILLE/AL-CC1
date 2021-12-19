package fr.esgi.quentinrouville.models.member;

import fr.esgi.quentinrouville.use_case.member.domain.model.EmailAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class EmailTest {
    @Test
    public void testEmail() {
        final EmailAddress email = EmailAddress.of("rouvilleq@gmail.com");
        assertEquals(email.toString(), "rouvilleq@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmailWithWrongEmail() {
        EmailAddress.of("rouvilleqgmail.com");
    }
}
