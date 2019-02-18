package com.denis.interview.algorithms.interviewcake.highestproductofthree;

import java.util.Arrays;

/**
 * Given an array of integers, find the highest product you can get from three of the integers.
 * The input arrayOfInts will always have at least three integers.
 */
public class HighestProductOfThree {


    public static int getMaxProductOf3WithSorting(int[] array) {

        if (array.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

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

        System.out.println(getMaxProductOf3EtalonSolution(array));
        System.out.println(getMaxProductOf3EtalonSolution(array2));

    }
}
