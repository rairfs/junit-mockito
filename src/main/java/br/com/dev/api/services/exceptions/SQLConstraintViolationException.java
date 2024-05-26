package br.com.dev.api.services.exceptions;

public class SQLConstraintViolationException extends RuntimeException{

    public SQLConstraintViolationException(String message) {
        super(message);
    }
}
