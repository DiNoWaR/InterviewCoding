package com.denis.interview.algorithms.graphs.wave;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MazeUtil {


    public static MazeNode[][] generateMaze(int size) {

        MazeNode[][] result = new MazeNode[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                MazeNode node = new MazeNode(i, j, false, 0, false);
                result[i][j] = node;
            }
        }
        return result;
    }


    public static void resetMaze(MazeNode[][] field) {

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field.length; j++) {
                field[i][j].mark = 0;
                field[i][j].wall = false;
                field[i][j].visited = false;
            }
        }

    }


    public static void setWall(MazeNode[][] field, int coordX, int coordY) {

        if (coordX < field.length && coordY < field.length) {
            field[coordX][coordY].wall = true;
        }
    }


    public static List<MazeNode> getNeighbours(MazeNode node, MazeNode[][] maze) {

        List<MazeNode> neighbours = new ArrayList<>();

        checkUpperNeighbour(node, maze, neighbours);
        checkDownNeighbour(node, maze, neighbours);
        checkLeftNeighbour(node, maze, neighbours);
        checkRightNeighbour(node, maze, neighbours);

        return neighbours;
    }


    private static void checkUpperNeighbour(MazeNode node, MazeNode[][] maze, List<MazeNode> neighbours) {

        if (node.x >= 1) {
            MazeNode first = maze[node.x - 1][node.y];
            neighbours.add(first);
        }
    }

    private static void checkDownNeighbour(MazeNode node, MazeNode[][] maze, List<MazeNode> neighbours) {

        if (node.x <= maze.length - 2) {
            MazeNode second = maze[node.x + 1][node.y];
            neighbours.add(second);
        }
    }

    private static void checkLeftNeighbour(MazeNode node, MazeNode[][] maze, List<MazeNode> neighbours) {
        if (node.y >= 1) {
            MazeNode third = maze[node.x][node.y - 1];
            neighbours.add(third);
        }
    }

    private static void checkRightNeighbour(MazeNode node, MazeNode[][] maze, List<MazeNode> neighbours) {

        if (node.y <= maze.length - 2) {
            MazeNode fourth = maze[node.x][node.y + 1];
            neighbours.add(fourth);
        }
    }
}
