package com.concepts.spring.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidFileParserContentException extends SpringApiException {
    static HttpStatus status = HttpStatus.BAD_REQUEST;
    public InvalidFileParserContentException(String msg) {
        super(status, msg);
    }

    public InvalidFileParserContentException(String message, Throwable cause) {
        super(status, message, cause);
    }

    public void setStatus(HttpStatus newStatus) {
        status = newStatus;
    }

}
