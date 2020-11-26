package com.concepts.spring.controller;

import com.concepts.spring.model.dto.FileDto;
import com.concepts.spring.services.FileParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class ParserController {

    FileParserService fileParserService;

    @PostMapping(value = "/ingest")
    String ingestJSon(@RequestBody @Valid FileDto fileDto) {
        log.trace("file dto ingested");
        fileParserService.parse(fileDto);
        return "Json Ingested";
    }

    @Autowired
    public void setFileParserService(FileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}

