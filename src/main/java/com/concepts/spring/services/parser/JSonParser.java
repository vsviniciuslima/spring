package com.concepts.spring.services.parser;

import com.concepts.spring.exceptions.InvalidFileParserContentException;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.model.factory.NodeFactory;
import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@Slf4j
public class JSonParser implements FileParser {

    @Override
    public Node buildTree(Object value) {

        log.trace("JSon Parser Accessed");
        JsonObject jsonObject = null;

        try {
            jsonObject = (JsonObject) JsonParser.parseString(value.toString());
        } catch (JsonSyntaxException e) {

            // @ControllerAdvice
            throw new InvalidFileParserContentException("O JSon do conteúdo é inválido", e);

            // ResponseStatusException
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

        return new NodeFactory().build(jsonObject);
    }
}
