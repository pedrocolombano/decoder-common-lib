package com.ead.commonlib.feignclient;

import com.ead.commonlib.exception.BadRequestException;
import com.ead.commonlib.exception.ProxyException;
import com.ead.commonlib.exception.ResourceNotFoundException;
import com.ead.commonlib.exception.ServiceUnavailableException;
import com.ead.commonlib.exception.handler.StandardError;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    @Override
    public Exception decode(final String methodKey, final Response response) {
        final StandardError standardError = getErrorResponse(response);
        switch (HttpStatus.valueOf(standardError.getStatusCode())) {
            case BAD_REQUEST:
                return new BadRequestException(standardError.getMessage());
            case NOT_FOUND:
                return new ResourceNotFoundException(standardError.getMessage());
            default:
                return new ProxyException(standardError.getMessage());
        }
    }

    private StandardError getErrorResponse(final Response response) {
        try (InputStream responseBody = response.body().asInputStream()) {
            return objectMapper.readValue(responseBody, StandardError.class);
        } catch (IOException e) {
            throw new ServiceUnavailableException("An error occurred during a request to a client service.");
        }
    }

}
