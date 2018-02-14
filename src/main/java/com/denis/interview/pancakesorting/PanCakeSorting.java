package com.denis.interview.pancakesorting;

import java.util.Arrays;

public class PanCakeSorting {


    public static void panCakeSort(int[] array) {

        int j = 1;

        while (j <= array.length - 1) {

            int indexOfMax = findIndexOfMaximum(array, array.length - j);

            flip(array, indexOfMax);
            flip(array, array.length - j);

            j++;
        }
    }


    private static void flip(int[] array, int index) {

        int left = 0;
        int right = index;

        while (left <= right) {
            swap(left, right, array);
            left++;
            right--;
        }

    }

    private static void swap(int sourceIndex, int targetIndex, int[] array) {
        int temp = array[targetIndex];
        array[targetIndex] = array[sourceIndex];
        array[sourceIndex] = temp;
    }

    private static int findIndexOfMaximum(int[] array, int rightIndex) {

        int max = 0;

        for (int i = 0; i <= rightIndex; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        int[] arr = {99, 3, 10, 2, 34, 120, 16, 21, 28, 1};

        panCakeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
