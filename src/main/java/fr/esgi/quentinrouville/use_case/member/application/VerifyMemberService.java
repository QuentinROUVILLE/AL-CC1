package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.use_case.member.domain.model.Member;

public final class VerifyMemberService
{
    private final MemberService memberService = new MemberService();

    public boolean isValid(Member member)
    {
        return member != null;
    }

    public boolean emailIsAlreadyTaken(String email)
    {
        return memberService.findAll().stream()
                .filter(member -> email.equals(member.getEmail().toString()))
                .findFirst()
                .orElse(null)
                != null;
    }
}
