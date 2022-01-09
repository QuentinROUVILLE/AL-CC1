package fr.esgi.quentinrouville.use_case.member.domain;

import fr.esgi.quentinrouville.kernel.Repository;

import java.util.List;
import java.util.NoSuchElementException;

public interface MemberRepository extends Repository<MemberId, Member>
{
    Member findById(MemberId id) throws NoSuchElementException;

    List<Member> findAll();
}
