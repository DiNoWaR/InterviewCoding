package com.denis.interview.algorithms.other.stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Note: Given n will be a positive integer.


 Example 1:

 Input: 2
 Output:  2
 Explanation:  There are two ways to climb to the top.

 1. 1 step + 1 step
 2. 2 steps
 */
public class Stairs {

    public static int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        var one = 1;
        var two = 0;

        var result = 0;

        for (var i = 1; i <= n; i++) {
            result = one + two;
            two = one;
            one = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

}
