package com.denis.interview.algorithms.interviewcake.highestproductofthree;

import java.util.Arrays;

public class HighestProductOfThree {

    public static int getMaxProductOfThree(int[] array) {

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

    public static int getMaxProductOfThreeSecond(int[] array) {

        if (array.length == 3) {
            return array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
        }

        int max1 = array[0];
        int max2 = array[0];
        int max3 = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] array = {0, -1000, 1, 5, -1000};
        System.out.println(getMaxProductOfThree(array));


    }
}
