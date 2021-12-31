package fr.esgi.quentinrouville.use_case.member.domain;

import java.util.List;

public interface MemberRepository
{
    void save(Member member);

    Member findById(MemberId memberId);

    MemberId nextIdentity();

    List<Member> findAll();
}
