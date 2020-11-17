package com.concepts.spring.services.documentAssembler;

import com.concepts.spring.model.entity.Node;

public interface DocAssRunner {
    void run(Node node);
    String getOutput();
}
