package com.concepts.spring.services.parser;

import com.concepts.spring.model.RuntimeTypeAdapterFactory;
import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.model.entity.Node;
import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(value = "prototype")
@Slf4j
public class JSonParser implements FileParser {

    @Value("${mockedNodeFromProperties}")
    String mockedNode;

    @Override
    public Node buildTree(Object value) {

        JsonObject mockedJsonObject = (JsonObject) JsonParser.parseString(mockedNode);

        /*
         * Implementação Original
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(value.toString());
        log.info(jsonObject.get("root").getAsString());
        //return Branch.builder().nodes(Arrays.asList()).build();
         */

        JsonObject jsonObject = (JsonObject) JsonParser.parseString(value.toString());

        RuntimeTypeAdapterFactory<Node> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Node.class, "Node.Node Type")
                .registerSubtype(Branch.class, "Node.Branch")
                .registerSubtype(Leaf.class, "Node.Leaf");

        Gson gsonObject = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();

        //exception handler
        // processo de log do spring e como podemos centralizá-los

        return gsonObject.fromJson(jsonObject, Branch.class);
    }

    private Node buildNode(JsonElement element){
        if(element.isJsonObject())
            return buildObject(element);
        else if(element.isJsonPrimitive())
            //return buildPrimitive(element);
        return null;
        else if(element.isJsonArray())
            return buildArray(element);
        else
            throw new RuntimeException("Not implemented");
    }

    private Node buildArray(JsonElement element) {

        return null;
    }

    private void buildPrimitive(JsonElement element) {

    }

    private Node buildObject(JsonElement element) {

        return null;
    }

}
