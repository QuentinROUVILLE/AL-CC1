package fr.esgi.quentinrouville.common.domain.services;

public class VerifyMemberService {
    public boolean emailIsAlreadyTaken(String email) {
        MemberService memberService = new MemberService();
        return memberService.findAll().stream()
                .filter(member -> email.equals(member.getEmail()))
                .findFirst()
                .orElse(null)
                != null;
    }
}
