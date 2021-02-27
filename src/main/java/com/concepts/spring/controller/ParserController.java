package com.concepts.spring.controller;

import com.concepts.spring.model.dto.FileDto;
import com.concepts.spring.services.FileParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class ParserController extends ValidationExceptionResolver {

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

}

