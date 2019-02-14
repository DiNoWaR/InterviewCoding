package com.denis.interview.algorithms.other.rand7;

/**
 * Given a function which produces a random integer in the range 1 to 5,
 * write a function which produces a random integer in the range 1 to 7.
 */
public class Rand7 {

    public static int rand7() {

        int[][] values = {
                {1, 2, 3, 4, 5},
                {6, 7, 1, 2, 3},
                {4, 5, 6, 7, 1},
                {2, 3, 4, 5, 6},
                {7, 0, 0, 0, 0}
        };

        int result = 0;

        while (result == 0) {
            int i = rand5();
            int j = rand5();
            result = values[i - 1][j - 1];
        }
        return result;
    }

    //mock for rand5
    private static int rand5() {
        return (int) (Math.random() * 5) + 1;
    }


    public static void main(String[] args) {
        System.out.println(rand7());
    }

}
