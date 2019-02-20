package com.denis.interview.algorithms.other.perfectsquare;

/**
 * Given a positive integer n, check if it is perfect square or not.
 * <p>
 * Note: Try to solve the question using only addition and subtraction operation.
 * <p>
 * Constraints:
 * <p>
 * 1<= N <=100000
 */
public class PerfectSquare {

    private static boolean isPerfectSquare(int number) {

        if (number == 1) {
            return true;
        }

        var k = 1;
        var i = 3;

        var s = k + i;

        while (s <= number) {

            if (s == number) {
                return true;
            }
            i = i + 2;
            s = s + i;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2501));
    }

}
