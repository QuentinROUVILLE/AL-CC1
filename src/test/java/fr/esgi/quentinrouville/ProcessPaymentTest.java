package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.common.domain.model.Member;
import fr.esgi.quentinrouville.common.domain.services.PaymentMethodService;
import fr.esgi.quentinrouville.common.domain.services.RegisterService;
import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.CreditCardPayment;
import org.junit.Test;

import static org.junit.Assert.*;

public final class ProcessPaymentTest
{
    private final RegisterService registerService = new RegisterService();
    private final PaymentMethodService paymentMethodService = new PaymentMethodService();

    @Test
    public void ShouldReturnFalseWhenAMemberHaventRegisterAPaymentMethod()
    {
        Member member = registerService.register("Quentin", "MOLERO", "qmolero@myges.fr", "password");

        System.out.println(member);

        assertFalse(paymentMethodService.ProcessPayment(member.getMemberId(), 39.99));
    }

    @Test
    public void ShouldReturnTrueWhenAMemberHaveRegisterAPaymentMethod()
    {
        Member member = registerService.register("Remy", "MACHAVOINE", "rmach@myges.fr", "password");

        member.setPaymentMethod(new CreditCardPayment("1234567890123456", "19/01", "123", "M REMY"));

        assertTrue(paymentMethodService.ProcessPayment(member.getMemberId(), 39.99));
    }
}
