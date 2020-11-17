package com.concepts.spring.services.actions;

import com.concepts.spring.model.entity.ActionType;

public class ActionStrategy {
    Action getAcion(ActionType actionType) {
        switch (actionType) {
            case LOG_INFO:
                return new LogInfoAction();
            default:
                return null;
        }

    }
}
