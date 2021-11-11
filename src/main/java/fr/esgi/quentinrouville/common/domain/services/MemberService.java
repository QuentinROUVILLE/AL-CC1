package fr.esgi.quentinrouville.common.domain.services;

import fr.esgi.quentinrouville.common.domain.model.MemberId;
import fr.esgi.quentinrouville.common.domain.repository.MemberRepository;
import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.infrastructure.memberRepository.InMemoryMemberRepository;

import java.util.List;

public final class MemberService {

    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = InMemoryMemberRepository.getInstance();
    }

    public void create(Member member) {
        this.memberRepository.save(member);
    }

    public MemberId nextIdentity(){
        return this.memberRepository.nextIdentity();
    }

    public void changePassword(MemberId memberId, String newPassword) {
        var member = this.memberRepository.byId(memberId);
        member.changePassword(newPassword);
        this.memberRepository.save(member);
    }

    public Member byId(MemberId MemberId) {
        return this.memberRepository.byId(MemberId);
    }

    public List<Member> all() {
        return this.memberRepository.findAll();
    }
}
