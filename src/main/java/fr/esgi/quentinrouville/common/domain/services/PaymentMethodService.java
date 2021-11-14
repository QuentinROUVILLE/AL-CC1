package fr.esgi.quentinrouville.common.domain.services;

import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.domain.model.MemberId;

public class PaymentMethodService
{
    private static final MemberService memberService = new MemberService();
    public boolean ProcessPayment(MemberId memberId, double amount) {
        Member member = memberService.findById(memberId);
        if(member.getPaymentMethod() != null){
            return member.getPaymentMethod().PayAmount(amount);
        }
        return false;
    }
}
