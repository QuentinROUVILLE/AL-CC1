package fr.esgi.quentinrouville.use_case.error.infrastructure;

import fr.esgi.quentinrouville.use_case.error.domain.Error;

public class SimpleQueryBusSendingException extends RuntimeException implements Error {
    private String errorCode = "4E-406";
    private String errorDefaultMessage = "The query is not valid";

    public SimpleQueryBusSendingException(String queryName) {
        errorDefaultMessage = "The query " + queryName + " is not valid";
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
