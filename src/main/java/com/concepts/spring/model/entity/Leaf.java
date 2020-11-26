package com.concepts.spring.model.entity;

import com.concepts.spring.model.ActionType;
import com.concepts.spring.services.documentAssembler.runner.DocAssRunner;
import lombok.Setter;

import java.util.List;

@Setter
public class Leaf extends Node {
    private String value;

    public Leaf(String value, List<ActionType> actionTypes) {
        this.value = value;
        this.actionTypes = actionTypes;
    }

    public Leaf() {
        super();
    }

    @Override
    public void acceptVisitor(DocAssRunner docAssRunner) {
        docAssRunner.runLeaf(this);
    }

    public String getValue() {
        return this.value;
    }

    public int getGrau() { return 0;}
}
