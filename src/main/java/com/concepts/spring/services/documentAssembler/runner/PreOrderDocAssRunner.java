package com.concepts.spring.services.documentAssembler.runner;

import com.concepts.spring.model.ActionType;
import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.actions.ActionStrategy;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContextEnum;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PreOrderDocAssRunner implements DocAssRunner {

    DocAssRunnerContext context;

    @Override
    public void runBranch(Branch branch) {

        executeActions(branch);

        branch.getNodes().keySet().forEach(id -> {
            branch.getNodes().get(id).acceptVisitor(this);
        });
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
    
    public PreOrderDocAssRunner(DocAssRunnerContextEnum contextEnum) {
        this.context = DocAssRunnerContextFactory.build(contextEnum);
    }

}
