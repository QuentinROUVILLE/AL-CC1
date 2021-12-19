package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.use_case.member.domain.model.Member;
import fr.esgi.quentinrouville.use_case.member.domain.model.MemberId;

public final class PaymentMethodService
{
    private static final MemberService memberService = new MemberService();

    public boolean ProcessPayment(MemberId memberId, double amount)
    {
        Member member = memberService.findById(memberId);

        if(member.getPaymentMethod() != null)
        {
            ApproveTradesman();

            return member.getPaymentMethod().PayAmount(amount);
        }

        return false;
    }

    public void ApproveTradesman()
    {
        System.out.println("Tradesman approve");
    }
}
