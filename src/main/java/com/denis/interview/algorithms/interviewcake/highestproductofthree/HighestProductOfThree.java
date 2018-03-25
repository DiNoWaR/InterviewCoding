package com.denis.interview.algorithms.interviewcake.highestproductofthree;

import java.util.Arrays;

public class HighestProductOfThree {

    public static int getMaxProductOf3WithSorting(int[] array) {

        Arrays.sort(array);

        if (array.length == 3 || array[array.length - 1] < 0 || array[0] > 0) {
            return array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
        }

        int result = 0;

        if (array[0] * array[1] > array[array.length - 2] * array[array.length - 3]) {
            result = array[0] * array[1] * array[array.length - 1];
        } else {
            result = array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
        }
        return result;
    }

    public static int getMaxProductOf3OurSolution(int[] array) {

        if (array.length == 3) {
            return array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
        }

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                max3 = max2;
                max2 = max;
                max = array[i];
            }
            if ((array[i] < max) && (array[i] >= max2)) {
                max3 = max2;
                max2 = array[i];
            }
            if ((array[i] < max2) && array[i] >= max3) {
                max3 = array[i];
            }
            if (array[i] <= min) {
                min2 = min;
                min = array[i];
            }
            if ((array[i] > min) && (array[i] < min2)) {
                min2 = array[i];
            }

        }
        if (max < 0) {
            return max * max2 * max3;
        }

        if ((max * max2 * max3 > max * min * min2)) {
            return max * max2 * max3;
        }

        return max * min * min2;
    }

    public static int getMaxProductOf3EtalonSolution(int[] array) {

        if (array.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // we're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(array[0], array[1]);
        int lowest = Math.min(array[0], array[1]);

        int highestProductOf2 = array[0] * array[1];
        int lowestProductOf2 = array[0] * array[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = array[0] * array[1] * array[2];

        // walk through items, starting at index 2
        for (int i = 2; i < array.length; i++) {
            int current = array[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2), current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(highestProductOf2, current * highest), current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(lowestProductOf2, current * highest), current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }

    public static void main(String[] args) {

        int[] array = {-1, -1000, -1, -5, -90};
        int[] array2 = {1, 100, 5, 100, 100};

        System.out.println(getMaxProductOf3OurSolution(array));
        System.out.println(getMaxProductOf3OurSolution(array2));

    }
}
