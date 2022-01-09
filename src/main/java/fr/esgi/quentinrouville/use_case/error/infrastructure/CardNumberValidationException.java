package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class CardNumberValidationException extends RuntimeException implements Error {
    private String errorCode = "4E-410";
    private String errorDefaultMessage = "The card number is not valid";

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDefaultMessage() {
        return errorDefaultMessage;
    }
}
