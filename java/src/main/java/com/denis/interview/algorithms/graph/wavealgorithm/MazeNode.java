package com.denis.interview.algorithms.graph.wavealgorithm;

public class MazeNode {

    public int x;
    public int y;
    public boolean wall;
    public int mark;
    public boolean visited;


    public MazeNode(int x, int y, boolean wall, int mark, boolean visited) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.mark = mark;
        this.visited = visited;
    }

    @Override
    public boolean equals(Object obj) {
        MazeNode node = (MazeNode) obj;
        return this.x == node.x && this.y == node.y;
    }
}
