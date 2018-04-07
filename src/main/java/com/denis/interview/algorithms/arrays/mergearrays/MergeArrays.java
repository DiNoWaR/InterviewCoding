package com.denis.interview.algorithms.arrays.mergearrays;

import java.util.Arrays;

/**
 * Merge two sorted arrays into one sorted array
 */
public class MergeArrays {

    public static int[] merge(int[] first, int[] second) {

        var merged = new int[first.length + second.length];

        var indexFirst = 0;
        var indexSecond = 0;

        for (var i = 0; i < merged.length; i++) {

            if (indexFirst < first.length & indexSecond < second.length) {

                if (first[indexFirst] < second[indexSecond]) {
                    merged[i] = first[indexFirst];
                    indexFirst++;
                } else {
                    merged[i] = second[indexSecond];
                    indexSecond++;
                }
            } else if (indexFirst == first.length) {
                System.arraycopy(second, indexSecond, merged, i, second.length - indexSecond);
                break;
            } else if (indexSecond == second.length) {
                System.arraycopy(first, indexFirst, merged, i, first.length - indexFirst);
                break;
            }

        }
        return merged;
    }

    public static void main(String[] args) {

        var first = new int[]{1, 5, 5, 56, 72};
        var second = new int[]{5, 7, 30, 200, 300, 332, 600, 800};

        var merged = merge(second, first);

        System.out.println(Arrays.toString(merged));
    }

}
