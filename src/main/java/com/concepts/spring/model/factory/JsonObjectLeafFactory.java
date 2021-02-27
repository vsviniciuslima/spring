package com.concepts.spring.model.factory;

import com.concepts.spring.model.entity.Leaf;
import com.google.gson.JsonObject;

public class JsonObjectLeafFactory extends LeafFactory<JsonObject> {

    @Override
    Leaf build(JsonObject jsonObject) {
        return new Leaf(jsonObject.get("value").getAsString(), new ActionTypesFactory().build(jsonObject));
    }
}
