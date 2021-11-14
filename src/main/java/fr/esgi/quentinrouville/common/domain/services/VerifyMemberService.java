package fr.esgi.quentinrouville.common.domain.services;

import fr.esgi.quentinrouville.common.domain.model.Member;

public class VerifyMemberService {
    public boolean isValid(Member member) {
        return member != null && !emailIsAlreadyTaken(member.getEmail());
    }

    public boolean emailIsAlreadyTaken(String email) {
        MemberService memberService = new MemberService();
        return memberService.findAll().stream()
                .filter(member -> email.equals(member.getEmail()))
                .findFirst()
                .orElse(null)
                != null;
    }
}
