package com.denis.interview.algorithms.graphs.wave;


public class FieldGenerator {

    public static Node[][] generateField(int size) {

        Node[][] result = new Node[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                Node node = new Node(i, j, false, false);
                result[i][j] = node;
            }
        }
        return result;
    }

    public static void refreshField(Node[][] field) {

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field.length; j++) {
                field[i][j].visited = false;
                field[i][j].wall = false;
            }
        }

    }

}
