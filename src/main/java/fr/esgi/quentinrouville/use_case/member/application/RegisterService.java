package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.use_case.member.domain.EmailAddress;
import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.Password;

public final class RegisterService
{
    public Member register(String firstName, String lastName, String email, String password)
    {
        MemberService memberService = new MemberService();
        final MemberId memberId = memberService.nextIdentity();
        final EmailAddress emailAddress = EmailAddress.of(email);
        final Password passwordValid = Password.of(password);

        Member member = Member.of(memberId, lastName, firstName, emailAddress, passwordValid);
        memberService.create(member);

        return member;
    }
}
