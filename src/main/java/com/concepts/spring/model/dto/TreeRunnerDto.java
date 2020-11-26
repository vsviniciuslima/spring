package com.concepts.spring.model.dto;

import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContextEnum;
import com.concepts.spring.services.documentAssembler.runner.DocAssRunnerEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TreeRunnerDto {

    @NotBlank(message = "Id is mandatory")
    String id;
    DocAssRunnerEnum runner;
    DocAssRunnerContextEnum context;
}
