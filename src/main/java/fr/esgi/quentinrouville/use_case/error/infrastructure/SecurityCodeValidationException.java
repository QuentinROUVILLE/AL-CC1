package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class SecurityCodeValidationException extends RuntimeException implements Error {
    private String errorCode = "4E-415";
    private String errorDefaultMessage = "The card security code is invalid";

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }
}
