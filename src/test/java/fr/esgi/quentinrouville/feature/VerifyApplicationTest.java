package fr.esgi.quentinrouville.feature;

import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.application.MemberService;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMember;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberCommandHandler;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.domain.MemberType;
import fr.esgi.quentinrouville.use_case.member.exposition.EmailAddressDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PasswordDTO;
import fr.esgi.quentinrouville.use_case.member.infrastructure.InMemoryMemberRepository;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public final class VerifyApplicationTest
{
    private static final MemberRepository memberRepository = InMemoryMemberRepository.getInstance();
    private static final EventDispatcher eventDispatcher = event -> System.out.println("Dispatching Event " + event.getClass().getName());

    private static final CreateMemberCommandHandler createMemberCommandHandler = CreateMemberCommandHandler.of(memberRepository, eventDispatcher);
    private final VerifyMember verifyMember = new VerifyMember();
    private final MemberService memberService = new MemberService();

    @BeforeClass
    public static void init()
    {
        createMemberCommandHandler.handle(CreateMember.of(
            MemberType.CONTRACTOR,
            "Quentin",
            "ROUVILLE",
            EmailAddressDTO.of("qrouville@myges.fr"),
            PasswordDTO.of("Azerty123@")
    ));
    }

    @Test
    public void ShouldReturnFalseWhenTheUserEmailIsntAlreadyOnTheStorage()
    {
        assertFalse(verifyMember.emailIsAlreadyTaken("quentin.rouville@orange.fr"));
    }

    @Test
    public void ShouldReturnTrueWhenTheUserEmailIsAlreadyOnTheStorage()
    {
        assertTrue(verifyMember.emailIsAlreadyTaken("qrouville@myges.fr"));
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
