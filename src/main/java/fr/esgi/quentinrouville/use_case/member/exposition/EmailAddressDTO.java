package fr.esgi.quentinrouville.use_case.member.exposition;

import java.util.Objects;

public final class EmailAddressDTO {
    public final String emailAddress;

    private EmailAddressDTO(String emailAddress) {
        this.emailAddress = Objects.requireNonNull(emailAddress);
    }

    public static EmailAddressDTO of(String emailAddress) {
        return new EmailAddressDTO(emailAddress);
    }

    @Override
    public String toString() {
        return "EmailAddressDTO{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
