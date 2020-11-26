package com.concepts.spring.services.documentAssembler.context;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class RawDocAssRunnerContext implements DocAssRunnerContext {
    private String output = "";
}
