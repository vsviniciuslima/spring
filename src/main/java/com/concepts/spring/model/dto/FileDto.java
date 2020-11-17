package com.concepts.spring.model.dto;

import com.concepts.spring.model.FileType;
import lombok.Data;

@Data
public class FileDto {

    FileType type;
    StringBuffer content;
}


