package com.concepts.spring.model.entity;

import com.concepts.spring.model.ActionType;
import com.concepts.spring.services.documentAssembler.runner.DocAssRunner;
import lombok.Builder;

import java.util.LinkedHashMap;
import java.util.List;

public class Branch extends Node {
    LinkedHashMap<String, Node> nodes = new LinkedHashMap<>();

    @Builder
    public Branch(LinkedHashMap<String, Node> nodes) {

        for (String id : nodes.keySet()) {
            this.addNode(nodes.get(id));
        }
    }

    @Builder
    public Branch(Node node) {
        this.nodes.put(node.getId(), node);
    }

    @Override
    public void acceptVisitor(DocAssRunner docAssRunner) {
        docAssRunner.runBranch(this);
    }

    public Branch() {
        super();
        this.grau = getGrau();
    }

    @Builder
    public Branch(String id, List<ActionType> actionTypes) {
        this.id = id;
        this.actionTypes = actionTypes;
    }

    public String getValue() {
        return "";
    }

    public LinkedHashMap<String, Node> getNodes() {
        return nodes;
    }

    public int getGrau() {

        int grau = 0;

        for (String id : nodes.keySet()) {
            grau++;
            grau += nodes.get(id).getGrau();
        }

        this.grau = grau;

        return grau;
    }

    public void addNode(Node node) {
        node.setNivel(this.getNivel() + 1);
        this.nodes.put(node.getId(), node);
        this.grau = getGrau();
    }

}
