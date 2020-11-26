package com.concepts.spring.services.documentAssembler.runner;

import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;

public interface DocAssRunner {

    void runBranch(Branch branch);
    void runLeaf(Leaf leaf);
    DocAssRunnerContext getContext();
}
