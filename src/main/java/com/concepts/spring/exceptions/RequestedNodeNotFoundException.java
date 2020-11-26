package com.concepts.spring.exceptions;

import com.concepts.spring.exceptions.SpringApiException;
import org.springframework.http.HttpStatus;

public class RequestedNodeNotFoundException extends SpringApiException {
    static HttpStatus status = HttpStatus.NOT_FOUND;
    public RequestedNodeNotFoundException(String msg) {
        super(status, msg);
    }

    public RequestedNodeNotFoundException(String message, Throwable cause) {
        super(status, message, cause);
    }

    public void setStatus(HttpStatus newStatus) {
        status = newStatus;
    }

}