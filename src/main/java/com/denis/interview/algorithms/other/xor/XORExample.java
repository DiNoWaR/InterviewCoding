package com.denis.interview.algorithms.other.xor;

/**
 * Swap two variables without temp variable
 */
public class XORExample {

    public static void main(String[] args) {

        int x = 2;
        int y = 3;

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println(x + " " + y);

    }
}
