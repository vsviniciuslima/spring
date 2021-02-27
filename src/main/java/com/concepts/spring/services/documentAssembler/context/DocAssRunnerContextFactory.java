package com.concepts.spring.services.documentAssembler.context;

import com.concepts.spring.enums.DocAssRunnerContextEnum;

public class DocAssRunnerContextFactory {
    public static DocAssRunnerContext build(DocAssRunnerContextEnum context) {
        if(context == null) {
            return new RawDocAssRunnerContext();
        } else {
            switch (context) {
/*                case HTML:
//                    return new HtmlDocAssRunnerContext();
                    return null;*/
                case RAW:
                    return new RawDocAssRunnerContext();
                default:
                    return null;
            }
        }
    }
}
