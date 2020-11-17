package com.concepts.spring.controller;

import com.concepts.spring.model.dto.FileDto;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.FileParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class ParserController {

    FileParserService fileParserService;

    @PostMapping(value = "/ingest")
    void ingestJSon(@RequestBody FileDto fileDto) {
        log.trace("file dto ingested");
        fileParserService.parse(fileDto);
    }

    @GetMapping("/get/{id}")
    public Node find(@PathVariable String id) {
        return fileParserService.find(id);
    }

    @Autowired
    public void setFileParserService(FileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }
}
