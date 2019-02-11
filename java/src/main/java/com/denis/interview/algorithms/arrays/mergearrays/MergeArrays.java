package com.denis.interview.algorithms.arrays.mergearrays;

import java.util.Arrays;

/**
 * Merge two sorted arrays into one sorted array
 */
public class MergeArrays {

    public static int[] merge(int[] first, int[] second) {

        var answer = new int[first.length + second.length];

        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            answer[k++] = first[i] < second[j] ? first[i++] : second[j++];
        }

        while (i < first.length) {
            answer[k++] = first[i++];
        }

        while (j < second.length) {
            answer[k++] = second[j++];
        }

        return answer;

    }

    public static void main(String[] args) {

        var first = new int[]{1, 5, 5, 56, 72};
        var second = new int[]{5, 7, 30, 200, 300, 332, 600, 800};

        var merged = merge(second, first);

        System.out.println(Arrays.toString(merged));
    }

}
