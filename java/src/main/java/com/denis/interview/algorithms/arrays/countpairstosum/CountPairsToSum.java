package com.denis.interview.algorithms.arrays.countpairstosum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of non-negative integers, and a value sum,
 * find how many pairs from array can we find to get value equal to given sum.
 */
public class CountPairsToSum {

    public static int countPairsOfElementsInArray(int[] array, int target) {

        var count = 0;

        Arrays.sort(array);

        for (var item : array) {

            var search = target - item;
            var elementIndex = Arrays.binarySearch(array, search);

            if (elementIndex >= 0) {
                count++;
            }
        }
        return count / 2;
    }

    public static int countPairsOfElementsWithHash(int[] array, int target) {

        int count = 0;

        Set<Integer> integers = new HashSet<>();

        for (int item : array) {
            int number = target - item;

            if (integers.contains(number)) {
                count++;
            } else {
                integers.add(item);
            }

        }
        return count;
    }


    public static void main(String[] args) {

        var p = new int[]{2, 3, 5, 8, 6, 0, 10, 1, 9};

        System.out.println(countPairsOfElementsInArray(p, 11));
        System.out.println(countPairsOfElementsWithHash(p, 11));
    }

}
