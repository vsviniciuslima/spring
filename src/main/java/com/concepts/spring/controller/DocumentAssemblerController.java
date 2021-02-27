package com.concepts.spring.controller;

import com.concepts.spring.model.dto.InputTreeRunnerDto;
import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.services.DocumentAssemblerService;
import com.concepts.spring.enums.DocAssRunnerContextEnum;
import com.concepts.spring.enums.DocAssRunnerEnum;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/docass")
@Slf4j
public class DocumentAssemblerController extends ValidationExceptionResolver {

    DocumentAssemblerService assemblerService;

    @GetMapping("/run")
    public String run(@RequestBody @Valid InputTreeRunnerDto inputTreeRunnerDto) {

        DocAssRunnerEnum docAssRunnerEnum;
        DocAssRunnerContextEnum docAssRunnerContextEnum;

        if(inputTreeRunnerDto.getRunner() == null) {
            docAssRunnerEnum = DocAssRunnerEnum.PRE_ORDER;
        } else {
            docAssRunnerEnum = DocAssRunnerEnum.valueOf(inputTreeRunnerDto.getRunner());
        }

        if(inputTreeRunnerDto.getContext() == null) {
            docAssRunnerContextEnum = DocAssRunnerContextEnum.RAW;
        } else {
            docAssRunnerContextEnum = DocAssRunnerContextEnum.valueOf(inputTreeRunnerDto.getContext());
        }

        TreeRunnerDto treeRunnerDto = new TreeRunnerDto(inputTreeRunnerDto.getId(), docAssRunnerEnum , docAssRunnerContextEnum);

        log.trace("document assembler runner started");

        return assemblerService.run(treeRunnerDto);
    }

    @Autowired
    public void setAssemblerService(DocumentAssemblerService assemblerService) {
        this.assemblerService = assemblerService;
    }
}
