package com.ead.commonlib.exception.handler;

import com.ead.commonlib.exception.InvalidSubscriptionException;
import com.ead.commonlib.exception.ProxyException;
import com.ead.commonlib.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleResourceNotFound(final ResourceNotFoundException exception,
                                                                final HttpServletRequest request) {
        final HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(notFoundStatus).body(createResponseBody(notFoundStatus, exception, request));
    }

    @ExceptionHandler(ProxyException.class)
    public ResponseEntity<StandardError> handleProxyError(final ProxyException exception,
                                                           final HttpServletRequest request) {
        final HttpStatus badGatewayStatus = HttpStatus.BAD_GATEWAY;
        return ResponseEntity.status(badGatewayStatus).body(createResponseBody(badGatewayStatus, exception, request));
    }

    @ExceptionHandler(InvalidSubscriptionException.class)
    public ResponseEntity<StandardError> handleInvalidSubscription(final InvalidSubscriptionException exception,
                                                                   final HttpServletRequest request) {
        final HttpStatus badGatewayStatus = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(badGatewayStatus).body(createResponseBody(badGatewayStatus, exception, request));
    }

    private StandardError createResponseBody(final HttpStatus status,
                                             final Exception exception,
                                             final HttpServletRequest request) {
        return StandardError.builder()
                .statusCode(status.value())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();
    }

}
