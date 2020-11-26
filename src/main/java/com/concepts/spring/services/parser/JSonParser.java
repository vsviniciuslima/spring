package com.concepts.spring.services.parser;

import com.concepts.spring.exceptions.InvalidFileParserContentException;
import com.concepts.spring.model.ActionType;
import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.model.entity.Node;
import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"e.getMessage().toString()", e);
        }

        return buildNode(jsonObject);
    }

    private Node buildNode(JsonObject jsonObject){

        if( jsonObject.has("nodes") ) {
            return buildBranch( jsonObject );
        } else {
            return buildLeaf( jsonObject );
        }
    }

    private Node buildBranch(JsonObject rootJsonObject) {

        String id = rootJsonObject.get("id").getAsString();
        List<ActionType> actionTypes = buildActionTypes(rootJsonObject);

        Branch root = new Branch(id, actionTypes);

        buildSubNodes(rootJsonObject, root);

        return root;
    }

    private void buildSubNodes(JsonObject rootJsonObject, Branch root) {
        JsonObject nodesJsonObject = rootJsonObject.get("nodes").getAsJsonObject();

        Set<Map.Entry<String, JsonElement>> nodes = nodesJsonObject.entrySet();

        for (Map.Entry<String, JsonElement> node : nodes) {

            root.addNode( buildNode( (JsonObject) node.getValue() ) );
        }
    }

    private List<ActionType> buildActionTypes(JsonObject rootJsonObject) {

        Gson gsonObject = new Gson();

        ActionType[] nodesArray = gsonObject.fromJson(rootJsonObject.get("actionTypes"), ActionType[].class);

        return Arrays.asList(nodesArray);
    }

    private Node buildLeaf(JsonObject jsonObject) {
        return new Leaf(jsonObject.get("value").getAsString(), buildActionTypes(jsonObject));
    }
}
