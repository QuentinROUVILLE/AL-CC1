package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class FindMemberException extends RuntimeException implements Error {
    private String errorCode = "4E-406";
    private String errorDefaultMessage = "No member";

    public FindMemberException(String memberId) {
        errorDefaultMessage = "No member for " + memberId;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }
}


