package com.concepts.spring.services.documentAssembler.runner;

import com.concepts.spring.enums.DocAssRunnerEnum;
import com.concepts.spring.enums.DocAssRunnerContextEnum;

public class DocAssRunnerFactory {
    public static DocAssRunner build(DocAssRunnerEnum runner, DocAssRunnerContextEnum context) {

        if(runner == null) {
            return new PreOrderDocAssRunner(context);
        } else {
            switch (runner) {
                case PRE_ORDER:
                    return new PreOrderDocAssRunner(context);
                case POS_ORDER:
                    return new PosOrderDocAssRunner(context);
                default:
                    return null;
            }
        }

    }
}
