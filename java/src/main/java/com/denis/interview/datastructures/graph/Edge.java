package com.denis.interview.datastructures.graph;


public class Edge<T> {

    private GraphNode<T> node1;
    private GraphNode<T> node2;
    private int weight;


    public Edge(GraphNode<T> node1, GraphNode<T> node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }


    public GraphNode<T> fromNode() {
        return node1;
    }

    public GraphNode<T> toNode() {
        return node2;
    }

    public boolean isBetween(GraphNode<T> node1, GraphNode<T> node2) {
        return (this.node1 == node1 && this.node2 == node2);
    }
}
