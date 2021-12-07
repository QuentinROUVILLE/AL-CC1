package fr.esgi.quentinrouville.common.domain.services;

import fr.esgi.quentinrouville.common.domain.model.member.EmailAddress;
import fr.esgi.quentinrouville.common.domain.model.member.Member;
import fr.esgi.quentinrouville.common.domain.model.member.MemberId;

public final class RegisterService
{
    public Member register(String firstName, String lastName, String email, String password)
    {
        MemberService memberService = new MemberService();
        final MemberId memberId = memberService.nextIdentity();
        final EmailAddress emailAddress = EmailAddress.of(email);

        Member member = Member.of(memberId, lastName, firstName, emailAddress, password);
        memberService.create(member);

        return member;
    }
}
