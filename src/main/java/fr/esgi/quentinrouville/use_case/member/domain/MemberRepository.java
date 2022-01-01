package fr.esgi.quentinrouville.use_case.member.domain;

import java.util.List;
import java.util.NoSuchElementException;

public interface MemberRepository
{
    void save(Member member);

    Member findById(MemberId memberId);

    MemberId nextIdentity() throws NoSuchElementException;

    List<Member> findAll();
}
