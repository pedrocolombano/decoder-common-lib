package com.ead.commonlib.exception;

public class InvalidDataException extends RuntimeException {

    private static final long serialVersionUID = -7179818152071190727L;

    public InvalidDataException(String message) {
        super(message);
    }

}
