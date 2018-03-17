package com.denis.interview.algorithms.ironman;

/**
 * IronMan is ready for battle. He starts his battle at index 0, moves in 1 index on the array each iteration.
 * Each index of array contains the number.If it's positive, charge of IronMan increases by number.Otherwise descrease by number.
 * If the charge of IronMan is less than 1, he dies.
 * Find minimum charge of IronMan to go through array and stay alive.
 *
 * Note: Array may be huge (10^5)
 */
public class IronMan {

    static int ironMan(int[] array) {

        int currentCharge = 0;

        int minCharge = 1;

        for (int item : array) {

            if (item >= 0) {
                currentCharge += item;
            } else {
                currentCharge += item;

                if (currentCharge < 1) {
                    minCharge = 1 - currentCharge;
                }
            }
        }
        return minCharge;
    }


    public static void main(String[] args) {

        int[] p = {-5, 4, -2, 3, 1, -1, -6, -1, 0, -5};

        System.out.println(ironMan(p));
    }

}
