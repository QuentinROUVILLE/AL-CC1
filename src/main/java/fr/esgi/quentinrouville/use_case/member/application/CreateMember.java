package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.Command;
import fr.esgi.quentinrouville.use_case.member.exposition.EmailAddressDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PasswordDTO;

import java.util.Objects;

public final class CreateMember implements Command {
    public final String firstName;
    public final String lastName;
    public final EmailAddressDTO email;
    public final PasswordDTO password;

    private CreateMember(String firstName, String lastName, EmailAddressDTO email, PasswordDTO password) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public static CreateMember of(String firstName, String lastName, EmailAddressDTO email, PasswordDTO password) {
        return new CreateMember(firstName, lastName, email, password);
    }
}
