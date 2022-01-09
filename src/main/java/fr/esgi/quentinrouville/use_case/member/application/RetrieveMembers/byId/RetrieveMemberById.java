package fr.esgi.quentinrouville.use_case.member.application.RetrieveMembers.byId;

import fr.esgi.quentinrouville.kernel.Query;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;

public class RetrieveMemberById implements Query {
    public final MemberId memberId;

    private RetrieveMemberById(MemberId memberId) {
        this.memberId = memberId;
    }

    public static RetrieveMemberById of(MemberId memberId) {
        return new RetrieveMemberById(memberId);
    }
}
