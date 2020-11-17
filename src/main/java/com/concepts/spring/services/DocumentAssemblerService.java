package com.concepts.spring.services;

import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.repository.TreeRepository;
import com.concepts.spring.services.documentAssembler.DocAssRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentAssemblerService {
    DocAssRunner docAssRunner;
    TreeRepository treeRepository;

    public String run(TreeRunnerDto treeRunnerDto) {

        log.info("processed node id: " + treeRunnerDto.getId());
        Node node = treeRepository.find(treeRunnerDto.getId());
        docAssRunner.run(node);
        return docAssRunner.getOutput();
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
