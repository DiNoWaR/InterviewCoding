package com.denis.interview.algorithms.graphs.wave;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class WaveAlgorithm {


    public static Stack<MazeNode> wave(MazeNode[][] maze, MazeNode start, MazeNode end) {

        Stack<MazeNode> path = new Stack<>();

        LinkedList<MazeNode> queue = new LinkedList<>();
        start.mark = 0;
        queue.add(start);

        if (propagateWave(maze, queue, end)) {
            recoverPath(maze, start, end, path);
        }

        return path;
    }

    private static void recoverPath(MazeNode[][] maze, MazeNode start, MazeNode end, Stack<MazeNode> path) {

        path.push(end);

        LinkedList<MazeNode> queue = new LinkedList<>();
        queue.add(end);

        while (true) {

            MazeNode current = queue.poll();

            if (current == null) {
                return;
            }

            if (current.equals(start)) {
                break;
            } else {
                List<MazeNode> neighbours = MazeUtil.getNeighbours(current, maze);

                for (MazeNode node : neighbours) {

                    if (node.mark == current.mark - 1) {
                        queue.add(node);
                        path.push(node);
                        break;
                    }
                }
            }
        }

    }

    private static boolean propagateWave(MazeNode[][] maze, LinkedList<MazeNode> queue, MazeNode end) {

        boolean pathExists = false;

        int mark = 0;

        while (true) {

            MazeNode current = queue.poll();

            if (current == null) {
                return false;
            }

            current.visited = true;

            if (current.equals(end)) {
                pathExists = true;
                break;
            } else {
                List<MazeNode> neighbours = MazeUtil.getNeighbours(current, maze);

                mark++;

                for (MazeNode node : neighbours) {

                    if (!node.visited && !node.wall) {
                        node.mark = mark;
                        queue.add(node);
                    }
                }
            }
        }
        return pathExists;
    }


    public static void main(String[] args) {

        MazeNode[][] maze = MazeUtil.generateMaze(20);

        for (int i = 0; i < 19; i++) {
            maze[i][3].wall = true;
        }

        Stack<MazeNode> path = wave(maze, maze[0][0], maze[4][4]);

        while (!path.isEmpty()) {

            MazeNode node = path.pop();

            System.out.println("Node X = " + node.x + " Y = " + node.y);
        }

    }
}
