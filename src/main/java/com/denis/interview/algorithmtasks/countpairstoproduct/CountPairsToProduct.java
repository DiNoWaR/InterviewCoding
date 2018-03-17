package com.denis.interview.algorithmtasks.countpairstoproduct;

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

        int result = -1;

        int rightIndex = array.length - 1;

        Arrays.sort(array);

        for (int i = array.length - 1; i > 0; i--) {

            int current = array[i];

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

        for (int i = 0; i < rightIndex; i++) {

            if (number % array[i] == 0) {
                int search = number / array[i];
                int index = Arrays.binarySearch(array, search);

                if (index > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void fillArray(int[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(array.length - 9) + 2;
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[999999];
        fillArray(arr);

        long start = System.currentTimeMillis();
        int result = countPairsOfElementsInArray(arr);
        long end = System.currentTimeMillis();

        System.out.println("Estimated Time: " + (end - start) + " ms");
        System.out.println(result);

    }

}
