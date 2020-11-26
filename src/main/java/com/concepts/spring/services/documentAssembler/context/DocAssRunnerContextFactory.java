package com.concepts.spring.services.documentAssembler.context;

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
