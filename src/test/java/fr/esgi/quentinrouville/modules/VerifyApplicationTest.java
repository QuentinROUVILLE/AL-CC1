package fr.esgi.quentinrouville.modules;

import fr.esgi.quentinrouville.use_case.member.application.MemberService;
import fr.esgi.quentinrouville.use_case.member.application.RegisterService;
import fr.esgi.quentinrouville.use_case.member.application.VerifyMemberService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public final class VerifyApplicationTest
{
    private final static RegisterService registerService = new RegisterService();
    private final VerifyMemberService verifyMemberService = new VerifyMemberService();
    private final MemberService memberService = new MemberService();

    @BeforeClass
    public static void init()
    {
        registerService.register("Quentin", "ROUVILLE", "qrouville@gmail.com", "Azerty@123");
    }

    @Test
    public void ShouldReturnFalseWhenTheUserEmailIsntAlreadyOnTheStorage()
    {
        assertFalse(verifyMemberService.emailIsAlreadyTaken("quentin.rouville@orange.fr"));
    }

    @Test
    public void ShouldReturnTrueWhenTheUserEmailIsAlreadyOnTheStorage()
    {
        assertTrue(verifyMemberService.emailIsAlreadyTaken("qrouville@gmail.com"));
    }

    @Test
    public void ShouldReturnFalseWhenTheUserIsNull()
    {
        assertFalse(verifyMemberService.isValid(null));
    }

    @Test(expected = Exception.class)
    public void ShouldReturnAnErrorWhenTheUserIsNull()
    {
        memberService.create(null);
    }
}
