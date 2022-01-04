package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.ApplicationEvent;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;

import java.util.Objects;

public final class CreateMemberEvent implements ApplicationEvent {
    private final MemberId memberId;

    private CreateMemberEvent(MemberId memberId) {
        this.memberId = Objects.requireNonNull(memberId);
    }

    public static CreateMemberEvent of(MemberId memberId) {
        return new CreateMemberEvent(memberId);
    }
}
