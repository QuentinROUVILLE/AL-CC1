package fr.esgi.quentinrouville.feature;

import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.application.PaymentMethodService;
import fr.esgi.quentinrouville.use_case.member.application.RegisterService;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CardExpirationDate;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CardNumber;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CardSecurityCode;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CreditCardPayment;
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
        final Member member = registerService.register("Quentin", "MOLERO", "qmolero@myges.fr", "Azerty123@");

        System.out.println(member);

        assertFalse(paymentMethodService.processPayment(member.getMemberId(), 39.99));
    }

    @Test
    public void ShouldReturnTrueWhenAMemberHaveRegisterAPaymentMethod()
    {
        final int year = Calendar.getInstance().get(Calendar.YEAR) + 1;
        final int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        final Member member = registerService.register("Remy", "MACHAVOINE", "rmach@myges.fr", "Azerty123@");

        member.setPaymentMethod(CreditCardPayment.of(
                CardNumber.of("1234567890123456"),
                CardExpirationDate.of(year, month),
                CardSecurityCode.of("123"),
                "M REMY"
        ));

        assertTrue(paymentMethodService.processPayment(member.getMemberId(), 39.99));
    }
}
