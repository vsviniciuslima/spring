package com.concepts.spring.model.entity;

import com.concepts.spring.enums.ActionType;

import com.concepts.spring.services.documentAssembler.runner.DocAssRunner;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public abstract class Node {
    String id;
    int grau;
    int nivel;
    public List<ActionType> actionTypes = new ArrayList<>();

    public Node() {
        this.id = UUID.randomUUID().toString();
    }

    public abstract void acceptVisitor(DocAssRunner docAssRunner);


    public abstract String getValue();
    public int getNivel() {
        return this.nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public abstract int getGrau();
    public List<ActionType> getActions() {
        return this.actionTypes;
    }
}
