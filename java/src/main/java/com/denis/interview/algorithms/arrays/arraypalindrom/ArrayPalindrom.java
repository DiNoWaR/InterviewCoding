package com.denis.interview.algorithms.arrays.arraypalindrom;

/**
 * Given an array. The task is to determine whether an array is a palindrome or not using recursion.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {3, 6, 0, 6, 3}
 * Output: Palindrome
 * <p>
 * Input: arr[] = {1, 2, 3, 4, 5}
 * Output: Not Palindrome
 */
public class ArrayPalindrom {


    public static boolean isArrayPalindrom(int[] array, int begin, int end) {

        if (array.length == 1) {
            return true;
        }

        if (begin >= end) {
            return true;
        }

        if (array[begin] == array[end]) {
            return isArrayPalindrom(array, begin + 1, end - 1);
        } else {
            return false;
        }

    }


    public static void main(String[] args) {

        int[] array = {3, 6, 0, 6, 3};

        System.out.println(isArrayPalindrom(array, 0, array.length - 1));

    }
}
