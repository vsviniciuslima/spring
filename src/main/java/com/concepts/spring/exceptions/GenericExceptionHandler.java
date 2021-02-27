package com.concepts.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidFileParserContentException.class, RequestedNodeNotFoundException.class})
    public ResponseEntity<Object> handleGenericException(SpringApiException e) {

        MsgTimeStampPayload fileParserException = new MsgTimeStampPayload (
                e.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(fileParserException, e.getHttpStatus());
    }
}
