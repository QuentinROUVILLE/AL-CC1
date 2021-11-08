package fr.esgi.quentinrouville.domain.repository;

import fr.esgi.quentinrouville.domain.model.MemberId;
import fr.esgi.quentinrouville.domain.model.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    Member byId(MemberId memberId);

    MemberId nextIdentity();

    List<Member> findAll();
}
