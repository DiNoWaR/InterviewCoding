package com.denis.interview.algorithms.arrays.countpairstoproduct;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an array of n elements, the task is to find the greatest number such that it is product of two elements of given array.
 * If no such element exists, print -1.
 * <p>
 * <p>
 * Input :  A[] = {10, 3, 5, 30, 35}
 * Output:  30
 * Explanation: 30 is the product of 10 and 3.
 * <p>
 * Input :  A[] = {2, 5, 7, 8}
 * Output:  -1
 * Explanation: Since, no such element exists.
 * <p>
 * Input :  A[] = {10, 2, 4, 30, 35}
 * Output:  -1
 * <p>
 * Input :  A[] = {10, 2, 2, 4, 30, 35}
 * Output:  4
 */
public class CountPairsToProduct {

    public static int countPairsOfElementsInArray(int[] array) {

        var result = -1;

        var rightIndex = array.length - 1;

        Arrays.sort(array);

        for (var i = array.length - 1; i > 0; i--) {

            var current = array[i];

            if (testNumber(current, array, rightIndex)) {
                result = current;
                break;
            } else {
                rightIndex--;
            }
        }
        return result;
    }

    private static boolean testNumber(int number, int[] array, int rightIndex) {

        for (var i = 0; i < rightIndex; i++) {

            if (number % array[i] == 0) {
                var search = number / array[i];
                var index = Arrays.binarySearch(array, search);

                if (index > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void fillArray(int[] array) {
        var rand = new Random();

        for (var i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(array.length - 9) + 2;
        }

    }

    public static void main(String[] args) {

        var arr = new int[999999];
        fillArray(arr);

        var start = System.currentTimeMillis();
        var result = countPairsOfElementsInArray(arr);
        var end = System.currentTimeMillis();

        System.out.println("Estimated Time: " + (end - start) + " ms");
        System.out.println(result);

    }

}
