package com.concepts.spring.services.parser;

import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Node;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(value = "prototype")
@Slf4j
public class YamlParser implements FileParser {

    @Override
    public Node buildTree(Object value) {
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(value.toString());
        log.info(jsonObject.get("root").getAsString());
        return null;
    }
}
