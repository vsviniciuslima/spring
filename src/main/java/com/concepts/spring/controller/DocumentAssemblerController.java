package com.concepts.spring.controller;

import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.services.DocumentAssemblerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/docass")
@Slf4j
public class DocumentAssemblerController {

    DocumentAssemblerService assemblerService;

    @GetMapping("/run")
    public String run(@RequestBody TreeRunnerDto treeRunnerDto) {
        log.trace("document assembler runner started");
        return assemblerService.run(treeRunnerDto);
    }

    @Autowired
    public void setAssemblerService(DocumentAssemblerService assemblerService) {
        this.assemblerService = assemblerService;
    }
}
