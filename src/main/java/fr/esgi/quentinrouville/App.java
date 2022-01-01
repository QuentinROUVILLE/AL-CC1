package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.use_case.member.domain.Member;
import fr.esgi.quentinrouville.use_case.member.application.PaymentMethodService;
import fr.esgi.quentinrouville.use_case.member.application.RegisterService;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CardExpirationDate;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CardNumber;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CardSecurityCode;
import fr.esgi.quentinrouville.use_case.member.infrastructure.CreditCardPayment;

public final class App
{
    public static void main( String[] args )
    {
        RegisterService registerService = new RegisterService();
        PaymentMethodService paymentMethodService = new PaymentMethodService();

        Member me = registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "Azerty123@");

        me.setPaymentMethod(CreditCardPayment.of(
                CardNumber.of("1234567890123456"),
                CardExpirationDate.of(2042, 12),
                CardSecurityCode.of("123"),
                "M QUENTIN ROUVILLE"
        ));

        paymentMethodService.processPayment(me.getMemberId(), 49.99);
    }
}
