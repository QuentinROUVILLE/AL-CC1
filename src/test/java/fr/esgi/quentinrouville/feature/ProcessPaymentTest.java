package fr.esgi.quentinrouville.feature;

import fr.esgi.quentinrouville.kernel.EventDispatcher;
import fr.esgi.quentinrouville.use_case.member.application.PaymentMethodService;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMember;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberCommandHandler;
import fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod.ModifyMemberPaymentMethod;
import fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod.ModifyMemberPaymentMethodCommandHandler;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.domain.MemberRepository;
import fr.esgi.quentinrouville.use_case.member.domain.MemberType;
import fr.esgi.quentinrouville.use_case.member.exposition.EmailAddressDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PasswordDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PaymentMethodDTO;
import fr.esgi.quentinrouville.use_case.member.infrastructure.InMemoryMemberRepository;
import fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard.CardExpirationDate;
import fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard.CardNumber;
import fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard.CardSecurityCode;
import fr.esgi.quentinrouville.use_case.member.infrastructure.paymentMethod.creditCard.CreditCardPayment;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class ProcessPaymentTest {
    private final MemberRepository memberRepository = InMemoryMemberRepository.getInstance();
    private final EventDispatcher eventDispatcher = event -> System.out.println("Dispatching Event " + event.getClass().getName());

    private final CreateMemberCommandHandler createMemberCommandHandler = CreateMemberCommandHandler.of(memberRepository, eventDispatcher);
    private final ModifyMemberPaymentMethodCommandHandler modifyMemberPaymentMethodCommandHandler = ModifyMemberPaymentMethodCommandHandler.of(memberRepository, eventDispatcher);
    private final PaymentMethodService paymentMethodService = new PaymentMethodService();

    @Test
    public void ShouldReturnFalseWhenAMemberHaventRegisterAPaymentMethod() {
        final MemberId memberId = createMemberCommandHandler.handle(CreateMember.of(
                MemberType.CONTRACTOR,
                "Quentin",
                "MOLERO",
                EmailAddressDTO.of("qmolero@myges.fr"),
                PasswordDTO.of("Azerty123@")
        ));

        assertFalse(paymentMethodService.processPayment(memberId, 39.99));
    }

    @Test
    public void ShouldReturnTrueWhenAMemberHaveRegisterAPaymentMethod() {
        final int year = Calendar.getInstance().get(Calendar.YEAR) + 1;
        final int month = Calendar.getInstance().get(Calendar.MONTH) + 1;

        final MemberId memberId = createMemberCommandHandler.handle(CreateMember.of(
                MemberType.CONTRACTOR,
                "Remy",
                "MACHAVOINE",
                EmailAddressDTO.of("rmach@myges.fr"),
                PasswordDTO.of("Azerty123@")
        ));

        modifyMemberPaymentMethodCommandHandler.handle(ModifyMemberPaymentMethod.of(
                memberId,
                PaymentMethodDTO.of(
                    CreditCardPayment.of(
                        CardNumber.of("1234567890123456"),
                        CardExpirationDate.of(year, month),
                        CardSecurityCode.of("123"),
                        "M REMY"
                    )
                )
        ));

        assertTrue(paymentMethodService.processPayment(memberId, 39.99));
    }
}
