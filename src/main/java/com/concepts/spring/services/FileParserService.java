package com.concepts.spring.services;

import com.concepts.spring.model.dto.FileDto;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.repository.TreeRepository;
import com.concepts.spring.services.parser.ParserStrategy;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FileParserService {

    ParserStrategy parserStrategy;
    TreeRepository treeRepository;

    public void parse(FileDto fileDto) {

        log.trace("processing fileDto");

        Node node = parserStrategy.getStrategy(fileDto.getType()).buildTree(fileDto.getContent().toString());

        treeRepository.save(node);
    }

    @Autowired
    public void setParserStrategy(ParserStrategy parserStrategy) {
        this.parserStrategy = parserStrategy;
    }

    @Autowired
    public void setTreeRepository(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public Node find(String id) {
        return treeRepository.find(id);
    }
}
