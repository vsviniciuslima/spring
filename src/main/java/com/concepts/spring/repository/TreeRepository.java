package com.concepts.spring.repository;

import com.concepts.spring.model.entity.Node;

import java.util.List;

public interface TreeRepository {
    boolean save(Node node);

    Node find(String id);

    List<Node> findAll();

    boolean remove(String id);
}
