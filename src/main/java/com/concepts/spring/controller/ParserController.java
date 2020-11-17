package com.concepts.spring.controller;

import com.concepts.spring.model.dto.FileDto;
import com.concepts.spring.model.dto.NodeDTO;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.FileParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ParserController {

    FileParserService fileParserService;

    @PostMapping(value = "/ingest")
    void ingestJSon(@RequestBody FileDto fileDto) {
        fileParserService.parse(fileDto);
    }

    @GetMapping("/{id}")
    public Node find(@PathVariable String id) {
        return fileParserService.find(id);
    }

    @Autowired
    public void setFileParserService(FileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }
}
