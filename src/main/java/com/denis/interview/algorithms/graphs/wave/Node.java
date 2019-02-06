package com.denis.interview.algorithms.graphs.wave;


public class Node {

    public int x;
    public int y;
    public boolean wall;
    public boolean visited;


    public Node(int x, int y, boolean wall, boolean visited) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.visited = visited;
    }

}
