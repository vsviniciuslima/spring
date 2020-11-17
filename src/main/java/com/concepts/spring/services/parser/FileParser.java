package com.concepts.spring.services.parser;

import com.concepts.spring.model.entity.Node;

public interface FileParser {
    Node buildTree(Object rawTree);
}
