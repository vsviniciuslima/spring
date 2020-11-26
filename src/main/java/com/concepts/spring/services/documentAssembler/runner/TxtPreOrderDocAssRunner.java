package com.concepts.spring.services.documentAssembler.runner;

import com.concepts.spring.model.ActionType;
import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.services.actions.ActionStrategy;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContext;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContextEnum;
import com.concepts.spring.services.documentAssembler.context.DocAssRunnerContextFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Scope(value = "prototype")
public class TxtPreOrderDocAssRunner implements DocAssRunner {

    DocAssRunnerContext context;

    @Override
    public void runBranch(Branch branch) {

        boolean postOrderActions = executeActions(branch);

        branch.getNodes().keySet().forEach(id -> {
            branch.getNodes().get(id).acceptVisitor(this);
        });

        if (postOrderActions) {

        }
    }

    @Override
    public void runLeaf(Leaf leaf) {
        executeActions(leaf);
    }

    private boolean executeActions(Node node) {

        AtomicBoolean postOrderActions = new AtomicBoolean(false);

        node.getActions().forEach(actionType -> {
            if(actionType == ActionType.WRITE_HTML) {
                postOrderActions.set(true);
            }
            new ActionStrategy().getAction(context, actionType).execute(node);
        });

        return postOrderActions.get();
    }

    @Override
    public DocAssRunnerContext getContext() {
        return context;
    }

    public TxtPreOrderDocAssRunner(DocAssRunnerContextEnum contextEnum) {
        this.context = DocAssRunnerContextFactory.build(contextEnum);
    }

}
