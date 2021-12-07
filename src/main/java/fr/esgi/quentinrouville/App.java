package fr.esgi.quentinrouville;

import fr.esgi.quentinrouville.common.domain.model.member.Member;
import fr.esgi.quentinrouville.common.domain.services.PaymentMethodService;
import fr.esgi.quentinrouville.common.domain.services.RegisterService;
import fr.esgi.quentinrouville.common.infrastructure.paymentMethod.creditCard.CreditCardPayment;

public final class App
{
    public static void main( String[] args )
    {
        RegisterService registerService = new RegisterService();
        PaymentMethodService paymentMethodService = new PaymentMethodService();

        Member me = registerService.register("Quentin", "ROUVILLE", "rouvilleq@gmail.com", "password");

        me.setPaymentMethod(CreditCardPayment.of("1234567890123456", "11/21", "123", "M QUENTIN ROUVILLE"));

        paymentMethodService.ProcessPayment(me.getMemberId(), 49.99);
    }
}
