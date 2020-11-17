package com.concepts.spring.services.actions;

import com.concepts.spring.model.entity.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInfoAction implements Action {

    @Override
    public void execute(Node node) {
        log.info(node.toString());
    }
}
