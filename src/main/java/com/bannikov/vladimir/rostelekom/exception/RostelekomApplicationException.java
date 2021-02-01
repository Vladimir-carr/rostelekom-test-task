package com.bannikov.vladimir.rostelekom.exception;

public abstract class RostelekomApplicationException extends RuntimeException {

    public RostelekomApplicationException(String message) {
        super(message);
    }

    public RostelekomApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RostelekomApplicationException(Throwable cause) {
        super(cause);
    }
}
