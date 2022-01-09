package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class EmailValidationException extends RuntimeException implements Error {
    private String errorCode = "4E-403";
    private String errorDefaultMessage = "The email is not valid";

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }
}
