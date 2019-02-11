package com.denis.interview.util;

public class DisjointsetNode<T> {

    private T value;

    private DisjointsetNode<T> parent;


    public DisjointsetNode(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }

    public DisjointsetNode<T> getParent() {
        return parent;
    }

    public void setParent(DisjointsetNode<T> parent) {
        this.parent = parent;
    }
}
