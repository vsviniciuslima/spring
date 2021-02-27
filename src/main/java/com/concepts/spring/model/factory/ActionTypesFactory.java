package com.concepts.spring.model.factory;

import com.concepts.spring.enums.ActionType;
import com.google.gson.*;
import java.util.*;

public class ActionTypesFactory {

    public List<ActionType> build(JsonObject rootJsonObject) {

        Gson gsonObject = new Gson();

        ActionType[] nodesArray = gsonObject.fromJson(rootJsonObject.get("actionTypes"), ActionType[].class);

        return Arrays.asList(nodesArray);
    }
}
