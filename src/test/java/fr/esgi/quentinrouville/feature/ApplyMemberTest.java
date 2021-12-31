package fr.esgi.quentinrouville.feature;

import fr.esgi.quentinrouville.use_case.member.domain.model.Member;
import fr.esgi.quentinrouville.use_case.member.application.MemberService;
import fr.esgi.quentinrouville.use_case.member.application.RegisterService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class ApplyMemberTest
{
    private final MemberService memberService = new MemberService();
    private final RegisterService registerService = new RegisterService();

    @Test
    public void ShouldCreateAMemberIfAllParametersAreProvided()
    {
        final Member newMember = registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "Azerty123@");

        assertEquals(memberService.findById(newMember.getMemberId()), newMember);
    }

    @Test(expected = NullPointerException.class)
    public void ShouldReturnAErrorIfNotAllParametersAreProvided()
    {
        registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", null);
    }
}
