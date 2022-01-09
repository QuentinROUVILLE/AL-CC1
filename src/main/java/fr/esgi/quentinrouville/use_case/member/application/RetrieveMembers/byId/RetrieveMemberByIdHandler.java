package fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers.byId;

import fr.esgi.quentinrouville.kernel.QueryHandler;
import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.exposition.MemberDTO;

import java.util.Objects;

public class RetrieveMemberByIdHandler implements QueryHandler<RetrieveMemberById, MemberDTO> {

    private final MemberRepository memberRepository;

    private RetrieveMemberByIdHandler(MemberRepository memberRepository) {
        this.memberRepository = Objects.requireNonNull(memberRepository);
    }

    public static RetrieveMemberByIdHandler of(MemberRepository memberRepository) {
        return new RetrieveMemberByIdHandler(memberRepository);
    }

    @Override
    public MemberDTO handle(RetrieveMemberById query) {
        Member member = memberRepository.findById(query.memberId);
        return MemberDTO.of(member.getMemberId(), member.getMemberType(), member.getLastName(), member.getFirstName(), member.getEmail(), member.getPassword(), member.getPaymentMethod());
    }
}
