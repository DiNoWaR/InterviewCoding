package com.denis.interview.algorithms.disjointset;

import com.denis.interview.util.DisjointsetNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement disjoint set data structure
 */
public class DisjointSet<T> {

    private List<DisjointsetNode<T>> disjointSet;


    public DisjointSet(int size) {
        disjointSet = new ArrayList<>(size);
    }


    public void makeSet(DisjointsetNode<T> node) {
        node.setParent(node);
    }


    public DisjointsetNode<T> find(DisjointsetNode<T> node) {

        if (node.getParent().getValue() == node.getValue()) {
            return node;
        } else {
            return find(node.getParent());
        }

    }

    public void union(DisjointsetNode<T> first, DisjointsetNode<T> second) {



    }


}
