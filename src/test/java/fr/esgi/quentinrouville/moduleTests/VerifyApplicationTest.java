package fr.esgi.quentinrouville.moduleTests;

import fr.esgi.quentinrouville.common.domain.services.RegisterService;
import fr.esgi.quentinrouville.common.domain.services.VerifyMemberService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerifyApplicationTest {
    @Before
    public void init() {
        RegisterService registerService = new RegisterService();
        registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "password");
    }

    @Test
    public void ShouldReturnFalseWhenTheUserEmailIsntAlreadyOnTheStorage() {
        VerifyMemberService verifyMemberService = new VerifyMemberService();

        assertFalse(verifyMemberService.emailIsAlreadyTaken("quentin.rouville@orange.fr"));
    }
    @Test
    public void ShouldReturnTrueWhenTheUserEmailIsAlreadyOnTheStorage() {
        VerifyMemberService verifyMemberService = new VerifyMemberService();

        assertTrue(verifyMemberService.emailIsAlreadyTaken("rouvilleq@gmail.com"));
    }
}
