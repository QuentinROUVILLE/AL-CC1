package fr.esgi.quentinrouville.modules;

import fr.esgi.quentinrouville.common.domain.model.member.Member;
import fr.esgi.quentinrouville.common.domain.services.PaymentMethodService;
import fr.esgi.quentinrouville.common.domain.services.RegisterService;
import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard.CardExpirationDate;
import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard.CardNumber;
import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard.CreditCardPayment;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public final class ProcessPaymentTest
{
    private final RegisterService registerService = new RegisterService();
    private final PaymentMethodService paymentMethodService = new PaymentMethodService();

    @Test
    public void ShouldReturnFalseWhenAMemberHaventRegisterAPaymentMethod()
    {
        Member member = registerService.register("Quentin", "MOLERO", "qmolero@myges.fr", "Azerty123@");

        System.out.println(member);

        assertFalse(paymentMethodService.ProcessPayment(member.getMemberId(), 39.99));
    }

    @Test
    public void ShouldReturnTrueWhenAMemberHaveRegisterAPaymentMethod()
    {
        final int year = Calendar.getInstance().get(Calendar.YEAR) + 1;
        final int month = Calendar.getInstance().get(Calendar.MONTH);
        final Member member = registerService.register("Remy", "MACHAVOINE", "rmach@myges.fr", "Azerty123@");

        member.setPaymentMethod(CreditCardPayment.of(
                CardNumber.of("1234567890123456"),
                CardExpirationDate.of(year, month),
                "123",
                "M REMY"
        ));

        assertTrue(paymentMethodService.ProcessPayment(member.getMemberId(), 39.99));
    }
}
