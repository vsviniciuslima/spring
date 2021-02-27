package com.concepts.spring.model.factory;

import com.concepts.spring.enums.ActionType;
import com.concepts.spring.model.entity.*;
import com.google.gson.*;
import java.util.*;

public class BranchFactory {

    public Node build(JsonObject rootJsonObject) {

        String id = rootJsonObject.get("id").getAsString();
        List<ActionType> actionTypes = new ActionTypesFactory().build(rootJsonObject);

        Branch root = new Branch(id, actionTypes);

        buildSubNodes(rootJsonObject, root);

        return root;
    }

    private void buildSubNodes(JsonObject rootJsonObject, Branch root) {

        JsonObject nodesJsonObject = rootJsonObject.get("nodes").getAsJsonObject();

        Set<Map.Entry<String, JsonElement>> nodes = nodesJsonObject.entrySet();

        for (Map.Entry<String, JsonElement> node : nodes) {

            root.addNode( new NodeFactory().build( (JsonObject) node.getValue() ) );
        }
    }
}
