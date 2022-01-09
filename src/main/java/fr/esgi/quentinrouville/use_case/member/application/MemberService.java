package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.feature.VerifyMember;
import fr.esgi.quentinrouville.use_case.error.infrastructure.MemberValidationException;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.infrastructure.InMemoryMemberRepository;

import java.util.List;

public final class MemberService
{
    private final MemberRepository memberRepository = InMemoryMemberRepository.getInstance();

    public void create(Member member)
    {
        VerifyMember verifyMember = new VerifyMember();

        if(!verifyMember.isValid(member))
        {
            throw new MemberValidationException();
        }

        this.memberRepository.save(member);
    }

    public MemberId nextIdentity()
    {
        return this.memberRepository.nextIdentity();
    }

    public Member findById(MemberId MemberId)
    {
        return this.memberRepository.findById(MemberId);
    }

    public List<Member> findAll()
    {
        return this.memberRepository.findAll();
    }
}
