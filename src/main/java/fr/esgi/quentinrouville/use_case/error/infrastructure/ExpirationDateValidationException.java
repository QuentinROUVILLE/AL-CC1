package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class ExpirationDateValidationException extends RuntimeException implements Error {
    private String errorCode = "4E-404";
    private String errorDefaultMessage = "The card expiration date is not valid";

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }
}
