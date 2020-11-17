package com.concepts.spring.services.documentAssembler;

import com.concepts.spring.model.entity.Node;
import com.concepts.spring.repository.TreeRepository;

public interface DocAssRunner {
    void run(Node node);
    String getOutput();
}
