package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class MemberValidationException extends RuntimeException implements Error {
    private String errorCode = "4E-407";
    private String errorDefaultMessage = "Member is not valid";

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }
}
