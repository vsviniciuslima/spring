package com.concepts.spring.services;

import com.concepts.spring.exceptions.RequestedNodeNotFoundException;
import com.concepts.spring.model.dto.TreeRunnerDto;
import com.concepts.spring.model.entity.Node;
import com.concepts.spring.repository.TreeRepository;
import com.concepts.spring.services.documentAssembler.runner.DocAssRunner;
import com.concepts.spring.services.documentAssembler.runner.DocAssRunnerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentAssemblerService {

    TreeRepository treeRepository;

    public String run(TreeRunnerDto treeRunnerDto) {

        log.info("processed node id: " + treeRunnerDto.getId());

        Node node = treeRepository.find(treeRunnerDto.getId());

        if (node == null) {
            throw new RequestedNodeNotFoundException("Nó solicitado não encontrado");
        }

        DocAssRunner docAssRunner = DocAssRunnerFactory.build(treeRunnerDto.getRunner(), treeRunnerDto.getContext());

        node.acceptVisitor(docAssRunner);

        return docAssRunner.getContext().getOutput();
    }

    @Autowired
    public void setTreeRepository(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }
}
