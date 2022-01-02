package fr.esgi.quentinrouville.use_case.member.domain;

import fr.esgi.quentinrouville.feature.VerifyMember;

import java.util.Objects;

public final class EmailAddress
{
    private final String email;

    private final VerifyMember verifyMember = new VerifyMember();

    private EmailAddress(String email) {
        if(!emailIsValid(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public static EmailAddress of(String email) {
        return new EmailAddress(email);
    }

    public boolean emailIsValid(String email) {
        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
                && !verifyMember.emailIsAlreadyTaken(email);
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailAddress)) return false;
        EmailAddress that = (EmailAddress) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
