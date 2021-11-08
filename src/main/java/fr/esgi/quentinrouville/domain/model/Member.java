package fr.esgi.quentinrouville.domain.model;

import java.util.Objects;

public class Member {
    private final MemberId memberId;
    private final String lastname;
    private final String firstname;
    private String password;

    private Member(MemberId memberId, String lastname, String firstname, String password) {
        this.memberId = memberId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    public static Member of(MemberId memberId, String lastname, String firstname, String password) {
        return new Member(memberId, lastname, firstname, password);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }
}
