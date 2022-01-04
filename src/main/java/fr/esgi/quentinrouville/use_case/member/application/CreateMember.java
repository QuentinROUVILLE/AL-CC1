package fr.esgi.quentinrouville.use_case.member.application;

import fr.esgi.quentinrouville.kernel.Command;
import fr.esgi.quentinrouville.use_case.member.domain.EmailAddress;
import fr.esgi.quentinrouville.use_case.member.domain.Password;

public final class CreateMember implements Command {
    public final String firstName;
    public final String lastName;
    public final EmailAddress email;
    public final Password password;

    public CreateMember(String firstName, String lastName, EmailAddress email, Password password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
