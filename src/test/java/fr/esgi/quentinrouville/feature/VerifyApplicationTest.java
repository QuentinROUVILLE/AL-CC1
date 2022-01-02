package fr.esgi.quentinrouville.feature;

import fr.esgi.quentinrouville.use_case.member.application.MemberService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public final class VerifyApplicationTest
{
    private final static RegisterMember registerService = new RegisterMember();
    private final VerifyMember verifyMember = new VerifyMember();
    private final MemberService memberService = new MemberService();

    @BeforeClass
    public static void init()
    {
        registerService.register("Quentin", "ROUVILLE", "qrouville@gmail.com", "Azerty@123");
    }

    @Test
    public void ShouldReturnFalseWhenTheUserEmailIsntAlreadyOnTheStorage()
    {
        assertFalse(verifyMember.emailIsAlreadyTaken("quentin.rouville@orange.fr"));
    }

    @Test
    public void ShouldReturnTrueWhenTheUserEmailIsAlreadyOnTheStorage()
    {
        assertTrue(verifyMember.emailIsAlreadyTaken("qrouville@gmail.com"));
    }

    @Test
    public void ShouldReturnFalseWhenTheUserIsNull()
    {
        assertFalse(verifyMember.isValid(null));
    }

    @Test(expected = Exception.class)
    public void ShouldReturnAnErrorWhenTheUserIsNull()
    {
        memberService.create(null);
    }
}
