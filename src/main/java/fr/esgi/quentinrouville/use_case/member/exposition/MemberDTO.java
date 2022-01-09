package fr.esgi.quentinrouville.use_case.member.exposition;

import fr.esgi.quentinrouville.use_case.member.domain.*;

public final class MemberDTO {
    public final MemberId id;
    public final MemberType type;
    public final String lastName;
    public final String firstName;
    public final EmailAddress email;
    public final Password password;
    public final PaymentMethod paymentMethod;

    private MemberDTO(MemberId id, MemberType type, String lastName, String firstName, EmailAddress email, Password password, PaymentMethod paymentMethod) {
        this.id = id;
        this.type = type;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.paymentMethod = paymentMethod;
    }

    public static MemberDTO of(MemberId id, MemberType type, String lastName, String firstName, EmailAddress email, Password password, PaymentMethod paymentMethod) {
        return new MemberDTO(id, type, lastName, firstName, email, password, paymentMethod);
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email=" + email +
                ", password=" + password +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
