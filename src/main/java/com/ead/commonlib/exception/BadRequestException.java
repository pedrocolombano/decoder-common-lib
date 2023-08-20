package com.ead.commonlib.exception;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -5364425397330128302L;

    public BadRequestException(final String message) {
        super(message);
    }
}
