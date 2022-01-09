package fr.esgi.quentinrouville.use_case.member.application.createMember;

import fr.esgi.quentinrouville.kernel.EventListener;

public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    @Override
    public void listenTo(CreateMemberEvent event) {
        System.out.println("Listening CreateMemberEvent.");
    }
}
