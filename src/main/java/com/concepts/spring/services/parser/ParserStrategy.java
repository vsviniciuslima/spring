package com.concepts.spring.services.parser;

import com.concepts.spring.model.FileType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class ParserStrategy {

    JSonParser jSonParser;
    YamlParser yamlParser;

    public ParserStrategy(JSonParser jSonParser, YamlParser yamlParser) {
        this.jSonParser = jSonParser;
        this.yamlParser = yamlParser;
    }

    // Factory Method
    public FileParser getStrategy(FileType type) {
        switch (type) {
            case JSON:
                return jSonParser;
            case YAML:
                return yamlParser;
            default:
                throw new RuntimeException(String.format("Not implemented %s", type));
        }
    }
}
