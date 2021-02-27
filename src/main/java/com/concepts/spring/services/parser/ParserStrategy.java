package com.concepts.spring.services.parser;

import com.concepts.spring.enums.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
@Slf4j
public class ParserStrategy {

    JSonParser jSonParser;
    YamlParser yamlParser;

    public ParserStrategy(JSonParser jSonParser, YamlParser yamlParser) {
        this.jSonParser = jSonParser;
        this.yamlParser = yamlParser;
    }

    public FileParser getStrategy(FileType type) throws NullPointerException {
        switch (type) {
            case JSON:
                return jSonParser;
            case YAML:
                return yamlParser;
            default:
                log.error(String.format("Not implemented %s", type));
                throw new NullPointerException(String.format("Not implemented %s", type));
        }
    }
}
