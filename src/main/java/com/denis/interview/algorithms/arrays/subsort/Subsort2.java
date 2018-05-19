package com.denis.interview.algorithms.arrays.subsort;

import java.util.Arrays;

public class Subsort2 {

    public int[] subSorting(int[] array) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int notSortedIndex1 = 0;
        int notSortedIndex2 = array.length - 1;
        int result1 = array.length-1;
        int result2 = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                notSortedIndex1 = i + 1;
                break;
            }
        }
        if (notSortedIndex1 == 0) {
            return null;
        }

        for (int i = array.length - 1; i >=0; i--) {
            if (array[i] < array[i - 1]) {
                notSortedIndex2 = i - 1;
                break;
            }
        }

        for (int i = notSortedIndex1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        for (int i = notSortedIndex2; i >= 0; i--) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int i = 0; i < notSortedIndex1; i++) {
            if (array[i] > min) {
                result1 = i;
                break;
            }
        }

        for (int i = array.length - 1; i > notSortedIndex2; i--) {
            if (array[i] < max) {
                result2 = i;
                break;
            }
        }
        return new int[]{result1, result2};
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] array2 = {111, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] array3 = {1, 5, 4, 7, 10, 11, 7, 12, 6, 19, 16, 18, 19};
        Subsort2 subsort2 = new Subsort2();
        System.out.println(Arrays.toString(subsort2.subSorting(array)));
        System.out.println(Arrays.toString(subsort2.subSorting(array2)));
        System.out.println(Arrays.toString(subsort2.subSorting(array3)));
    }
}
