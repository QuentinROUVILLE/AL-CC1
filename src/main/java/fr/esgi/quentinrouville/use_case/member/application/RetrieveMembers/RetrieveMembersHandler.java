package fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers;

import fr.esgi.quentinrouville.kernel.QueryHandler;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.exposition.MemberDTO;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveMembersHandler implements QueryHandler<RetrieveMembers, List<MemberDTO>> {
    private final MemberRepository memberRepository;

    public RetrieveMembersHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static RetrieveMembersHandler of(MemberRepository memberRepository) {
        return new RetrieveMembersHandler(memberRepository);
    }

    @Override
    public List<MemberDTO> handle(RetrieveMembers query) {
        return memberRepository.findAll()
                .stream()
                .map(member ->
                        MemberDTO.of(
                                member.getMemberId(),
                                member.getMemberType(),
                                member.getLastName(),
                                member.getFirstName(),
                                member.getEmail(),
                                member.getPassword(),
                                member.getPaymentMethod()))
                .collect(Collectors.toList());
    }
}
