package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.domain.model.MemberId;
import fr.esgi.quentinrouville.common.domain.repository.MemberRepository;
import fr.esgi.quentinrouville.common.infrastructure.memberRepository.InMemoryMemberRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplyMemberTest {
    @Test
    public void CreateAMember() {
        MemberRepository inMemoryMemberRepository = new InMemoryMemberRepository();
        final MemberId memberId = inMemoryMemberRepository.nextIdentity();
        Member member = Member.of(memberId, "ROUVILLE", "Quentin", "password");
        inMemoryMemberRepository.save(member);

        assertEquals(inMemoryMemberRepository.byId(memberId), member);
    }
}
