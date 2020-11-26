package com.concepts.spring.services.actions;

import com.concepts.spring.model.ActionType;
import com.concepts.spring.services.actions.implementations.ConcatValueAction;
import com.concepts.spring.services.actions.implementations.LogInfoAction;
import com.concepts.spring.services.actions.implementations.WriteTxtFileAction;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;

public class ActionStrategy {

    public Action getAction(DocAssRunnerContext context, ActionType actionType) {
        switch (actionType) {
            case LOG_INFO:
                return new LogInfoAction(context);
            case CONCAT_VALUE:
                return new ConcatValueAction(context);
            case WRITE_FILE:
                return new WriteTxtFileAction(context);
            default:
                return null;
        }
    }
}