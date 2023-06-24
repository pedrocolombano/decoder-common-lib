package com.ead.commonlib.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2169864149919715991L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
