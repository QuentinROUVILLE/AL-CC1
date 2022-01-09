package fr.esgi.quentinrouville.use_case.member.application.modifyMemberPaymentMethod;

import fr.esgi.quentinrouville.kernel.EventListener;

public class ModifyMemberPaymentMethodEventListener implements EventListener<ModifyMemberPaymentMethodEvent> {
    @Override
    public void listenTo(ModifyMemberPaymentMethodEvent event) {
        System.out.println("Listening ModifyMemberPaymentMethodEvent.");
    }
}
