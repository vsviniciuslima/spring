package com.concepts.spring.controller;

import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.services.DocumentAssemblerService;
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
@RequestMapping("/docass")
@Slf4j
public class DocumentAssemblerController {

    DocumentAssemblerService assemblerService;

    @GetMapping("/run")
    public String run(@RequestBody @Valid TreeRunnerDto treeRunnerDto) {
        log.trace("document assembler runner started");
        return assemblerService.run(treeRunnerDto);
    }

    @Autowired
    public void setAssemblerService(DocumentAssemblerService assemblerService) {
        this.assemblerService = assemblerService;
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
