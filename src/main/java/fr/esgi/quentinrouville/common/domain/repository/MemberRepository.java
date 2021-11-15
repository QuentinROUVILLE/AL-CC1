package fr.esgi.quentinrouville.common.domain.repository;

import fr.esgi.quentinrouville.common.domain.model.MemberId;
import fr.esgi.quentinrouville.common.domain.model.Member;

import java.util.List;

public interface MemberRepository
{
    void save(Member member);

    Member findById(MemberId memberId);

    MemberId nextIdentity();

    List<Member> findAll();
}
