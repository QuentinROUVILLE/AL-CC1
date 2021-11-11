package fr.esgi.quentinrouville.moduleTests;

import fr.esgi.quentinrouville.applyMemberModule.RegisterService;
import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.infrastructure.memberRepository.InMemoryMemberRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplyMemberTest {
    @Test
    public void CreateAMember() {
        RegisterService registerService = new RegisterService();
        InMemoryMemberRepository inMemoryMemberRepository = InMemoryMemberRepository.getInstance();
        Member newMember = registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "password");

        assertEquals(inMemoryMemberRepository.byId(newMember.getMemberId()), newMember);
    }
}
