package com.denis.interview.algorithms.graphs.wave;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Implement wave algorithm for path routing
 */
public class WaveAlgorithm {


    public static Stack<MazeNode> wave(MazeNode[][] maze, MazeNode start, MazeNode end) {

        Stack<MazeNode> path = new Stack<>();

        LinkedList<MazeNode> queue = new LinkedList<>();

        start.mark = 0;
        start.visited = true;
        queue.add(start);

        if (propagateWave(maze, queue, end)) {
            recoverPath(maze, start, end, path);
        }

        return path;
    }

    private static boolean propagateWave(MazeNode[][] maze, LinkedList<MazeNode> queue, MazeNode end) {

        boolean pathExists = false;

        while (!queue.isEmpty()) {

            MazeNode current = queue.poll();

            if (current.equals(end)) {
                pathExists = true;
                break;
            } else {
                List<MazeNode> neighbours = MazeUtil.getNeighbours(current, maze);

                for (MazeNode node : neighbours) {

                    if (!node.visited && !node.wall) {
                        node.mark = current.mark + 1;
                        node.visited = true;
                        queue.add(node);
                    }
                }
            }
        }
        return pathExists;
    }

    private static void recoverPath(MazeNode[][] maze, MazeNode start, MazeNode end, Stack<MazeNode> path) {

        LinkedList<MazeNode> queue = new LinkedList<>();

        path.push(end);
        queue.add(end);

        while (!queue.isEmpty()) {

            MazeNode current = queue.poll();

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


    public static void main(String[] args) {

        int size = 5;

        MazeNode[][] maze = MazeUtil.generateMaze(size);

        MazeUtil.setWall(maze, 0, 1);
        MazeUtil.setWall(maze, 1, 1);
        MazeUtil.setWall(maze, 2, 1);
        MazeUtil.setWall(maze, 3, 1);
        MazeUtil.setWall(maze, 4, 3);
        MazeUtil.setWall(maze, 3, 3);
        MazeUtil.setWall(maze, 2, 3);


        Stack<MazeNode> path = wave(maze, maze[0][0], maze[size - 1][size - 1]);

        while (!path.isEmpty()) {

            MazeNode node = path.pop();
            System.out.println("Node X = " + node.x + " Y = " + node.y);
        }
    }
}
