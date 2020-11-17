package com.concepts.spring.repository;

import com.concepts.spring.model.entity.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Scope(value = "singleton")
@Slf4j
public class MemoryFileRepository implements TreeRepository {
    Map<String, Node> store;

    @Override
    public boolean save(Node node) {

        log.trace("node saved");
        log.info("saved node id: " + node.getId());

        getStore().put(node.getId(), node);
        return true;
    }

    @Override
    public Node find(String id) {
        return store.get(id);
    }

    @Override
    public List<Node> findAll() {
        return null;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    public Map<String, Node> getStore() {
        return store = Optional.ofNullable(store).orElseGet(HashMap::new);
    }
}
