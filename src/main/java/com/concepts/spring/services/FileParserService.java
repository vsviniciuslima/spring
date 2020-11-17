package com.concepts.spring.services;

import com.concepts.spring.model.dto.FileDto;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.repository.TreeRepository;
import com.concepts.spring.services.parser.ParserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileParserService {

    ParserStrategy parserStrategy;
    TreeRepository treeRepository;

    public void parse(FileDto fileDto) {

        Node node = parserStrategy.getStrategy(fileDto.getType()).buildTree(fileDto.getContent().toString());
        treeRepository.save(node);
        System.out.println("Node salvo:");
        System.out.println(node.toString());
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
