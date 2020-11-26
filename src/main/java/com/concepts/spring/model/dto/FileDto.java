package com.concepts.spring.model.dto;

import com.concepts.spring.model.FileType;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FileDto {

    @NotNull(message = "File type is mandatory")
    @JsonEnumDefaultValue
    FileType type;
    @NotBlank(message = "Content is mandatory")
    StringBuffer content;
}


