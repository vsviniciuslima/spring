package com.concepts.spring.services.documentAssembler.runner;

import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.actions.ActionStrategy;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import com.concepts.spring.enums.DocAssRunnerContextEnum;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContextFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PosOrderDocAssRunner implements DocAssRunner {

    DocAssRunnerContext context;

    @Override
    public void runBranch(Branch branch) {

        branch.getNodes().keySet().forEach(id -> {
            branch.getNodes().get(id).acceptVisitor(this);
        });

        executeActions(branch);
    }

    @Override
    public void runLeaf(Leaf leaf) {
        executeActions(leaf);
    }

    private void executeActions(Node node) {
        node.getActions().forEach(actionType -> {
            new ActionStrategy().getAction(context, actionType).execute(node);
        });
    }

    @Override
    public DocAssRunnerContext getContext() {
        return context;
    }

    public PosOrderDocAssRunner(DocAssRunnerContextEnum contextEnum) {
        this.context = DocAssRunnerContextFactory.build(contextEnum);
    }

}
