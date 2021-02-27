package com.concepts.spring.services.actions.implementations;

import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.actions.AbstractAction;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInfoAction extends AbstractAction {

    public LogInfoAction(DocAssRunnerContext context) {
        super(context);
    }

    @Override
    public void execute(Node node) {
        log.info(node.toString());
    }
}
