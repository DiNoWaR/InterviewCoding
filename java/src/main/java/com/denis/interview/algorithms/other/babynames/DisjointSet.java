package com.denis.interview.algorithms.other.babynames;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement disjoint set data structure
 */
public class DisjointSet {

    private Map<String, DisjointSetNode> nodesMap;


    public DisjointSet(Map<String, Integer> names) {

        nodesMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : names.entrySet()) {

            DisjointSetNode node = new DisjointSetNode(entry.getKey(), entry.getValue(), names.entrySet().size());
            node.setParent(node);
            nodesMap.put(entry.getKey(), node);
        }

    }

    //Find with Path compression
    public DisjointSetNode find(String name) {

        DisjointSetNode node = nodesMap.get(name);

        if (node == null) {
            return null;
        }

        if (node.getParent().getName().equals(name)) {
            return node;
        }

        node.setParent(find(node.getParent().getName()));

        return find(node.getParent().getName());

    }

    //Union by rank
    public void union(String firstName, String secondName) {

        DisjointSetNode firstNode = find(firstName);
        DisjointSetNode secondNode = find(secondName);

        if (firstNode == null || secondNode == null || firstNode.getName().equals(secondNode.getName())) {
            return;
        }

        if (firstNode.getRank() < secondNode.getRank()) {
            firstNode.setParent(secondNode);
            firstNode.setRank(firstNode.getRank() - 1);
        } else {
            secondNode.setParent(firstNode);
            secondNode.setRank(secondNode.getRank() - 1);
        }

    }

    public Map<String, DisjointSetNode> getNodesMap() {
        return nodesMap;
    }
}
