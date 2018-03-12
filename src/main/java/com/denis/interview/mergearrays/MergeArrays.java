package com.denis.interview.mergearrays;

import java.util.Arrays;

/**
 * Merge two sorted arrays into one sorted array
 */
public class MergeArrays {

    public static int[] merge(int[] first, int[] second) {

        int[] small = first;
        int[] big = second;

        if (first.length > second.length) {
            small = second;
            big = first;
        }

        int[] merged = new int[first.length + second.length];

        int firstCurrentIndex = 0;
        int secondCurrentIndex = 0;

        for (int i = 0; i < merged.length; i++) {

            if (firstCurrentIndex < small.length && small[firstCurrentIndex] < big[secondCurrentIndex]) {
                merged[i] = small[firstCurrentIndex];
                firstCurrentIndex++;
            } else {

                if (secondCurrentIndex < big.length) {
                    merged[i] = big[secondCurrentIndex];
                    secondCurrentIndex++;
                }
            }
        }
        return merged;
    }


    public static void main(String[] args) {

        int[] first = {1, 5, 5, 56, 72, 96, 100, 300};
        int[] second = {5, 7, 30, 200, 300, 332, 600, 800};

        int[] merged = merge(first, second);

        System.out.println(Arrays.toString(merged));
    }

}
