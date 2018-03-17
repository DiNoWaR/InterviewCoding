package com.denis.interview.algorithmtasks.closestpalindrom;

/**
 * Given a number N. our task is to find the closest Palindrome number
 * whose absolute difference with given number is minimum.
 */
public class ClosestPalindrom {

    public static long findClosestPalindrom(long number) {

        if (number < 10) {
            return number - 1;
        }

        for (long i = number - 1; i > 0; i--) {
            if (isPalindrom(i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isPalindrom(long number) {

        long remainder;
        long sum = 0;
        long temp = number;

        while (number > 0) {
            remainder = number % 10;
            sum = (sum * 10) + remainder;
            number = number / 10;
        }

        if (temp == sum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findClosestPalindrom(11));
    }

}
