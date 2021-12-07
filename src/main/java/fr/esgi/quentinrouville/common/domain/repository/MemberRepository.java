package fr.esgi.quentinrouville.common.domain.repository;

import fr.esgi.quentinrouville.common.domain.model.member.MemberId;
import fr.esgi.quentinrouville.common.domain.model.member.Member;

import java.util.List;

public interface MemberRepository
{
    void save(Member member);

    Member findById(MemberId memberId);

    MemberId nextIdentity();

    List<Member> findAll();
}
