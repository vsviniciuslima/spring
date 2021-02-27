package com.concepts.spring.model.dto;

import com.concepts.spring.enums.FileType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FileDto {

    @NotNull(message = "File type is mandatory")
    FileType type;
    @NotBlank(message = "Content is mandatory")
    StringBuffer content;
}


