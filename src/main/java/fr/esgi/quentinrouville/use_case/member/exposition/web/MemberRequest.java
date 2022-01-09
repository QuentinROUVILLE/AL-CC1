package fr.esgi.quentinrouville.use_case.member.exposition.web;

import fr.esgi.quentinrouville.use_case.member.domain.MemberType;

public class MemberRequest {
    public MemberType memberType;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
