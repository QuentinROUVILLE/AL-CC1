package fr.esgi.quentinrouville.common.domain.services;

import fr.esgi.quentinrouville.common.domain.model.member.Member;
import fr.esgi.quentinrouville.common.domain.model.member.MemberId;

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
