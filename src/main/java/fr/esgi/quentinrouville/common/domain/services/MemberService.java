package fr.esgi.quentinrouville.common.domain.services;

import fr.esgi.quentinrouville.common.domain.model.member.MemberId;
import fr.esgi.quentinrouville.common.domain.repository.MemberRepository;
import fr.esgi.quentinrouville.common.domain.model.member.Member;
import fr.esgi.quentinrouville.common.infrastructure.memberRepository.InMemoryMemberRepository;

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
