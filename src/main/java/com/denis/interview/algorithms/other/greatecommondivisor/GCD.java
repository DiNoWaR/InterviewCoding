package com.denis.interview.algorithms.other.greatecommondivisor;

/**
 * Write function to find greate common divisor between 2 Integers
 */
public class GCD {

    public static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}
