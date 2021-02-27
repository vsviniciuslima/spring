package com.concepts.spring.model.dto;

import com.concepts.spring.config.annotations.validator.ValueOfEnum;
import com.concepts.spring.enums.DocAssRunnerContextEnum;
import com.concepts.spring.enums.DocAssRunnerEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InputTreeRunnerDto {

    @NotBlank(message = "Id is mandatory")
    String id;
    @ValueOfEnum(enumClass = DocAssRunnerEnum.class, message = "Runner is incorrect")
    String runner;
    @ValueOfEnum(enumClass = DocAssRunnerContextEnum.class, message = "Context is incorrect")
    String context;
}
