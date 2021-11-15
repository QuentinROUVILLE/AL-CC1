package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.domain.services.MemberService;
import fr.esgi.quentinrouville.common.domain.services.RegisterService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplyMemberTest
{
    private final MemberService memberService = new MemberService();
    private final RegisterService registerService = new RegisterService();

    @Test
    public void ShouldCreateAMemberIfAllParametersAreProvided()
    {
        Member newMember = registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "password");

        assertEquals(memberService.findById(newMember.getMemberId()), newMember);
    }

    @Test(expected = NullPointerException.class)
    public void ShouldReturnAErrorIfNotAllParametersAreProvided()
    {
        registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", null);
    }
}
