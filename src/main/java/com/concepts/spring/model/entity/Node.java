package com.concepts.spring.model.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Data
public abstract class Node {
    String id;
    String value;
    LinkedHashMap<String, Node> nodes;
    List<ActionType> actionTypes;

    public Node() {
        this.id = UUID.randomUUID().toString();
    }

    public Node(String value, LinkedHashMap<String, Node> nodes) {
        this.value = value;
        this.nodes = nodes;
    }

}
