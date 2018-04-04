package com.denis.interview.algorithms.arrays.pancakesorting;

/**
 * We are given an array of integers and the only allowed operation to change array is
 * to take several elements from beginning to some index and flip them.
 * Write implementation of pancake sorting.
 */
public class PanCakeSorting {


    public static void panCakeSort(int[] array) {

        var j = 1;

        while (j <= array.length - 1) {

            var indexOfMax = findIndexOfMaximum(array, array.length - j);

            flip(array, indexOfMax);
            flip(array, array.length - j);

            j++;
        }
    }


    private static void flip(int[] array, int index) {

        var left = 0;
        var right = index;

        while (left <= right) {
            swap(left, right, array);
            left++;
            right--;
        }

    }

    private static void swap(int sourceIndex, int targetIndex, int[] array) {
        var temp = array[targetIndex];
        array[targetIndex] = array[sourceIndex];
        array[sourceIndex] = temp;
    }

    private static int findIndexOfMaximum(int[] array, int rightIndex) {

        var max = 0;

        for (var i = 0; i <= rightIndex; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }


}
