package fr.esgi.quentinrouville.applyMemberModule;

import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.domain.model.MemberId;
import fr.esgi.quentinrouville.common.domain.repository.MemberRepository;
import fr.esgi.quentinrouville.common.infrastructure.memberRepository.InMemoryMemberRepository;

public final class RegisterService {
    public Member register(String firstName, String lastName, String password) {
        MemberRepository inMemoryMemberRepository = InMemoryMemberRepository.getInstance();
        final MemberId memberId = inMemoryMemberRepository.nextIdentity();
        Member member = Member.of(memberId, lastName, firstName, password);
        inMemoryMemberRepository.save(member);

        return member;
    }
}
