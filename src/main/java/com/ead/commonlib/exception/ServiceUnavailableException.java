package com.ead.commonlib.exception;

public class ServiceUnavailableException extends RuntimeException {

    private static final long serialVersionUID = -2330068788856834549L;

    public ServiceUnavailableException(final String message) {
        super(message);
    }
}
