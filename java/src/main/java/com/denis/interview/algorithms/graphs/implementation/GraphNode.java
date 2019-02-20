package com.denis.interview.algorithms.graphs.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GraphNode<T> {

    private T vertex;
    private List<Edge<T>> edges;

    private GraphNode<T> parent;
    private boolean isVisited;


    public GraphNode(T vertex) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
    }


    public T vertex() {
        return vertex;
    }


    public boolean addEdge(GraphNode<T> node, int weight) {
        if (hasEdge(node)) {
            return false;
        }
        Edge<T> newEdge = new Edge<>(this, node, weight);
        return edges.add(newEdge);
    }

    public boolean removeEdge(GraphNode<T> node) {
        Optional<Edge<T>> optional = findEdge(node);
        if (optional.isPresent()) {
            return edges.remove(optional.get());
        }
        return false;
    }

    public boolean hasEdge(GraphNode<T> node) {
        return findEdge(node).isPresent();
    }

    private Optional<Edge<T>> findEdge(GraphNode<T> node) {
        return edges.stream()
                .filter(edge -> edge.isBetween(this, node))
                .findFirst();
    }

    public List<Edge<T>> edges() {
        return edges;
    }

    public int getEdgeCount() {
        return edges.size();
    }

    public GraphNode<T> parent() {
        return parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setParent(GraphNode<T> parent) {
        this.parent = parent;
    }
}
