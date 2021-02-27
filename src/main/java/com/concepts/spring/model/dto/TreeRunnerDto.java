package com.concepts.spring.model.dto;

import com.concepts.spring.enums.DocAssRunnerContextEnum;
import com.concepts.spring.enums.DocAssRunnerEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class TreeRunnerDto {

    @NotBlank(message = "Id is mandatory")
    String id;
    DocAssRunnerEnum runner;
    DocAssRunnerContextEnum context;
}
