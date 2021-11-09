package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.domain.model.Member;
import fr.esgi.quentinrouville.domain.model.MemberId;
import fr.esgi.quentinrouville.domain.repository.MemberRepository;
import fr.esgi.quentinrouville.infrastructure.InMemoryMemberRepository;
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
