package fr.esgi.quentinrouville.use_case.member.application;

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
        VerifyMemberService verifyMemberService = new VerifyMemberService();

        if(verifyMemberService.isValid(member))
        {
            System.out.println("The member " + member.getFirstName() + " " + member.getLastName() + " has been created.");

            this.memberRepository.save(member);
        }
        else
        {
            throw new IllegalArgumentException("Member mustn't be null.");
        }
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
