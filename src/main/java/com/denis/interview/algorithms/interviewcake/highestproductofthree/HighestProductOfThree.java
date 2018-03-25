package com.denis.interview.algorithms.interviewcake.highestproductofthree;

import java.util.Arrays;

public class HighestProductOfThree {

    public static int getMaxProductOfThreeWithSorting(int[] array) {

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

    public static int getMaxProductOfThree(int[] array) {

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

    public static void main(String[] args) {

        int[] array = {-1, -1000, -1, -5, -90};
        int[] array2 = {1, 100, 5, 100, 100};

        System.out.println(getMaxProductOfThree(array));
        System.out.println(getMaxProductOfThree(array2));

    }
}
