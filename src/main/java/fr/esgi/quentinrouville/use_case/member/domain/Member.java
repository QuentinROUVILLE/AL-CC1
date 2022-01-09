package fr.esgi.quentinrouville.use_case.member.domain;

import java.util.Objects;

public final class Member
{
    private final MemberId memberId;
    private final MemberType memberType;
    private final String lastname;
    private final String firstname;
    private final EmailAddress email;
    private final Password password;
    private PaymentMethod paymentMethod;

    private Member(MemberId memberId, MemberType memberType, String lastname, String firstname, EmailAddress email, Password password)
    {
        this.memberId = Objects.requireNonNull(memberId);
        this.memberType = Objects.requireNonNull(memberType);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public static Member of(MemberId memberId, MemberType memberType, String lastname, String firstname, EmailAddress email, Password password)
    {
        return new Member(memberId, memberType, lastname, firstname, email, password);
    }

    public MemberId getMemberId()
    {
        return memberId;
    }

    @Override
    public String toString()
    {
        return "Member{" +
                "memberId=" + memberId +
                ", memberType=" + memberType +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public EmailAddress getEmail()
    {
        return email;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod)
    {
        this.paymentMethod = Objects.requireNonNull(paymentMethod);
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void changePaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
