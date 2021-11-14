package fr.esgi.quentinrouville.common.domain.model;

import java.util.Objects;

public class Member {
    private final MemberId memberId;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final String password;

    private Member(MemberId memberId, String lastname, String firstname, String email, String password) {
        this.memberId = Objects.requireNonNull(memberId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public static Member of(MemberId memberId, String lastname, String firstname, String email, String password) {
        return new Member(memberId, lastname, firstname, email, password);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }
}
