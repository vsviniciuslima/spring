package com.concepts.spring.services.documentAssembler;

import com.concepts.spring.model.entity.Branch;
import com.concepts.spring.model.entity.Leaf;
import com.concepts.spring.model.entity.Node;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class InCloudDocAssRunner implements DocAssRunner {

    public String output = "";

    public void setOutput(String value) {

        this.output += value;
    }

    @Override
    public void run(Node node) {

        if (node instanceof Leaf) {

            this.setOutput(node.getValue() + " ");

        } else if (node instanceof Branch) {

            for(String id : node.getNodes().keySet() ) {
                run(node.getNodes().get(id));
            }
        }
    }

    public String getOutput() {
        return this.output;
    }
}
