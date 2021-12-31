package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;

public final class PaymentMethodService
{
    private static final MemberService memberService = new MemberService();

    public boolean processPayment(MemberId memberId, double amount)
    {
        Member member = memberService.findById(memberId);

        if(member.getPaymentMethod() != null)
        {
            approveTradesman();

            return member.getPaymentMethod().payAmount(amount);
        }

        return false;
    }

    public void approveTradesman()
    {
        System.out.println("Tradesman approve");
    }
}
