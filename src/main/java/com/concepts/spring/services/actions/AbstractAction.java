package com.concepts.spring.services.actions;

import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import lombok.Getter;


public abstract class AbstractAction implements Action{

    @Getter
    DocAssRunnerContext context;

    public AbstractAction(DocAssRunnerContext context) {
        this.context=context;
    }
}
