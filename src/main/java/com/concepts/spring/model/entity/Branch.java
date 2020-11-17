package com.concepts.spring.model.entity;

import lombok.Builder;

import java.util.LinkedHashMap;

public class Branch extends Node {

    @Override
    public String getValue() {
        return null;
    }

    @Builder
    public Branch(LinkedHashMap<String, Node> nodes) {
        this.nodes = nodes;
    }

    @Builder
    public Branch(Node node) {
        this.nodes.put(node.getId(), node);
    }

}
