package com.concepts.spring.model.factory;

import com.concepts.spring.model.entity.Node;
import com.google.gson.JsonObject;


public class NodeFactory {

    public  Node build(JsonObject jsonObject) {

        if( jsonObject.has("nodes") ) {
            return new BranchFactory().build(jsonObject);
        } else {
            return new JsonObjectLeafFactory().build(jsonObject);
        }
    }
}
