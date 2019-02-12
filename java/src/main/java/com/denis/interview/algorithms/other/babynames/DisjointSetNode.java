package com.denis.interview.algorithms.other.babynames;

import lombok.Getter;

@Getter
public class DisjointSetNode {

    private String name;
    private Integer frequency;
    private Integer rank;

    private DisjointSetNode parent;


    public DisjointSetNode(String name, Integer frequency,Integer rank) {
        this.name = name;
        this.frequency = frequency;
        this.rank = rank;

    }


    public void setParent(DisjointSetNode parent) {
        this.parent = parent;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
