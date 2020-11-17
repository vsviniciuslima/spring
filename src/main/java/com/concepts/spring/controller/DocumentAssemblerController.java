package com.concepts.spring.controller;

import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.services.DocumentAssemblerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/docass")
public class DocumentAssemblerController {

    DocumentAssemblerService assemblerService;

    @PostMapping("/run")
    public void run(@RequestBody TreeRunnerDto treeRunnerDto) {
        assemblerService.run(treeRunnerDto);
    }

    @Autowired
    public void setAssemblerService(DocumentAssemblerService assemblerService) {
        this.assemblerService = assemblerService;
    }
}
