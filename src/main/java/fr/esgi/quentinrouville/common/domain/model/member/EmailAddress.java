package fr.esgi.quentinrouville.common.domain.model.member;

import java.util.Objects;

public final class EmailAddress {
    private final String email;

    private EmailAddress(String email) {
        if(!EmailIsValid(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = Objects.requireNonNull(email);
    }

    public boolean EmailIsValid(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

    public static EmailAddress of(String email) {
        return new EmailAddress(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
