package fr.esgi.quentinrouville.use_case.member.application.createMember;

import fr.esgi.quentinrouville.kernel.Command;
import fr.esgi.quentinrouville.use_case.member.domain.MemberType;
import fr.esgi.quentinrouville.use_case.member.exposition.EmailAddressDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PasswordDTO;

import java.util.Objects;

public final class CreateMember implements Command {
    public MemberType memberType;
    public final String firstName;
    public final String lastName;
    public final EmailAddressDTO email;
    public final PasswordDTO password;

    private CreateMember(MemberType memberType, String firstName, String lastName, EmailAddressDTO email, PasswordDTO password) {
        this.memberType = Objects.requireNonNull(memberType);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public static CreateMember of(MemberType memberType, String firstName, String lastName, EmailAddressDTO email, PasswordDTO password) {
        return new CreateMember(memberType, firstName, lastName, email, password);
    }
}
