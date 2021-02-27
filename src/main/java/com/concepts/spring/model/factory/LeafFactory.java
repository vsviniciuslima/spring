package com.concepts.spring.model.factory;

import com.concepts.spring.model.entity.Leaf;

public abstract class LeafFactory<T> {

    abstract Leaf build(T instance);
}
