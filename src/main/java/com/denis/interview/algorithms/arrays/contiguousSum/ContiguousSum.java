package com.denis.interview.algorithms.arrays.contiguousSum;

/**
 * Write an efficient program to find the sum of contiguous subarray
 * within a one-dimensional array of numbers which has the largest sum.
 */
public class ContiguousSum {

    public static int findContiguousSum(int[] array) {

        var maxSoFar = 0;
        var maxEndingHere = 0;

        for (var item : array) {

            maxEndingHere += item;

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }


    public static void main(String[] args) {

        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(findContiguousSum(array));

    }
}
