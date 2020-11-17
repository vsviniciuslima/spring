package com.concepts.spring.services;

import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.repository.TreeRepository;
import com.concepts.spring.services.documentAssembler.DocAssRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DocumentAssemblerService {
    DocAssRunner docAssRunner;
    TreeRepository treeRepository;

    public void run(TreeRunnerDto treeRunnerDto) {

        Node node = treeRepository.find(treeRunnerDto.getId());
        docAssRunner.run(node);
        System.out.println("output: " + docAssRunner.getOutput());
    }

    @Autowired
    public void setDocAssRunner(DocAssRunner docAssRunner) {
        this.docAssRunner = docAssRunner;
    }

    @Autowired
    public void setTreeRepository(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }
}
