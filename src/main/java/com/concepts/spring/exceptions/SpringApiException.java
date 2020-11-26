package com.concepts.spring.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


public abstract class SpringApiException extends RuntimeException {
    
    @Getter
    HttpStatus httpStatus;

    public SpringApiException(HttpStatus status) {
        super();
        this.httpStatus = status;
    }

    public SpringApiException(HttpStatus status, String msg) {
        super(msg);
        this.httpStatus = status;
    }

    public SpringApiException(HttpStatus status, String msg, Throwable throwable) {
        super(msg, throwable);
        this.httpStatus = status;
    }

/*    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }*/

}
