package fr.esgi.quentinrouville.use_case.member.domain;

import java.util.Objects;

public final class Password
{
    private final String password;

    private Password(String password) {
        if(!passwordIsValid(password)) {
            throw new IllegalArgumentException("Password is not valid");
        }
        this.password = password;
    }

    public static Password of(String password) {
        return new Password(password);
    }

    private boolean passwordIsValid(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

    @Override
    public String toString() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password)) return false;
        Password password1 = (Password) o;
        return password.equals(password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}