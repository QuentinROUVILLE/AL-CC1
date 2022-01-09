package fr.esgi.quentinrouville.use_case.member.exposition.web;

import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMember;
import fr.esgi.quentinrouville.use_case.member.application.createMember.CreateMemberCommandHandler;
import fr.esgi.quentinrouville.use_case.member.domain.MemberId;
import fr.esgi.quentinrouville.use_case.member.exposition.EmailAddressDTO;
import fr.esgi.quentinrouville.use_case.member.exposition.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/users")
public class MemberController {
    private final CreateMemberCommandHandler createMemberCommandHandler;

    @Autowired
    public MemberController(CreateMemberCommandHandler createMemberCommandHandler) {
        this.createMemberCommandHandler = createMemberCommandHandler;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody MemberRequest request) {
        CreateMember createMember = CreateMember.of(request.memberType, request.firstName, request.lastName, EmailAddressDTO.of(request.email), PasswordDTO.of(request.password));
        MemberId memberId = createMemberCommandHandler.handle(createMember);
        return ResponseEntity.ok(null);
    }
}
