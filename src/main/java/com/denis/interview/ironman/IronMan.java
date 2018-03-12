package com.denis.interview.ironman;

/**
 *
 */
public class IronMan {

    static int ironMan(int[] array) {

        int current = 0;

        int minCharge = 1;

        for (int item : array) {

            if (item >= 0) {
                current += item;
            } else {
                current += item;

                if (current < 1) {
                    minCharge = 1 - current;
                }
            }
        }
        return minCharge;
    }


    public static void main(String[] args) {

        int[] p = {-5, 4, -19, 3, 1, -1, -6, -1, 0, 5, -13};

        System.out.println(ironMan(p));

    }

}
