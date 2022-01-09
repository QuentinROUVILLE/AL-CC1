package fr.esgi.quentinrouville.feature;

import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers.byId.RetrieveMemberById;
import fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers.byId.RetrieveMemberByIdHandler;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMember;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberCommandHandler;
import fr.esgi.quentinrouville.use_case.member.domain.*;
import fr.esgi.quentinrouville.use_case.member.application.MemberService;
import fr.esgi.quentinrouville.use_case.member.exposition.EmailAddressDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.MemberDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PasswordDTO;
import fr.esgi.quentinrouville.use_case.member.infrastructure.InMemoryMemberRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class ApplyMemberTest
{
    private final MemberRepository memberRepository = InMemoryMemberRepository.getInstance();
    private final EventDispatcher eventDispatcher = event -> System.out.println("Dispatching Event " + event.getClass().getName());

    private final CreateMemberCommandHandler createMemberCommandHandler = CreateMemberCommandHandler.of(memberRepository, eventDispatcher);
    private final RetrieveMemberByIdHandler retrieveMemberByIdHandler = RetrieveMemberByIdHandler.of(memberRepository);

    @Test
    public void ShouldCreateAMemberIfAllParametersAreProvided()
    {
        final MemberId memberId = createMemberCommandHandler.handle(CreateMember.of(
                MemberType.CONTRACTOR,
                "Quentin",
                "ROUVILLE",
                EmailAddressDTO.of("rouvilleq@gmail.com"),
                PasswordDTO.of("Azerty123@")
        ));

        final MemberDTO member = retrieveMemberByIdHandler.handle(RetrieveMemberById.of(memberId));

        assertEquals(member.lastName, "ROUVILLE");
    }

    @Test(expected = NullPointerException.class)
    public void ShouldReturnAErrorIfNotAllParametersAreProvided()
    {
        final MemberId memberId = createMemberCommandHandler.handle(CreateMember.of(
                MemberType.CONTRACTOR,
                "Quentin",
                "ROUVILLE",
                EmailAddressDTO.of("rouvilleq@gmail.com"),
                null
        ));
    }
}
