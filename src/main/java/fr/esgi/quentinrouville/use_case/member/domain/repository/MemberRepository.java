package fr.esgi.quentinrouville.use_case.member.domain.repository;

import fr.esgi.quentinrouville.use_case.member.domain.model.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.model.Member;

import java.util.List;

public interface MemberRepository
{
    void save(Member member);

    Member findById(MemberId memberId);

    MemberId nextIdentity();

    List<Member> findAll();
}
