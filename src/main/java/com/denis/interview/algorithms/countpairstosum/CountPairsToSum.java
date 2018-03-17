package com.denis.interview.algorithms.countpairstosum;

import java.util.Arrays;

/**
 *
 */
public class CountPairsToSum {


    public static int countPairsOfElementsInArray(int[] array, int target) {

        int count = 0;

        Arrays.sort(array);

        for (int item : array) {

            int search = target - item;
            int elementIndex = Arrays.binarySearch(array, search);

            if (elementIndex >= 0) {
                count++;
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {

        int[] p = {2, 3, 5, 8, 6, 0};

        System.out.println(countPairsOfElementsInArray(p, 8));
    }

}
