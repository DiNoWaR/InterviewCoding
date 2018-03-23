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

        return 0;
    }

    public static void main(String[] args) {

        int[] array = {0, -1000, 1, 5, -1000};

        int[] arrayOfInts = new int[]{1, 10, -5, 1, -100};

        System.out.println(getMaxProductOfThree(array));
        System.out.println(getMaxProductOfThree(arrayOfInts));


    }
}
