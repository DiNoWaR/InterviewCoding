package com.denis.interview.algorithms.arrays.threewaypartition;

/**
 * Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts.
 * 1) All elements smaller than lowVal come first.
 * 2) All elements in range lowVal to highVVal come next.
 * 3) All elements greater than highVVal appear in the end.
 * The individual elements of three sets can appear in any order.
 *
 * Examples:
 *
 * Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
 * lowVal = 14, highVal = 20
 * Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}
 *
 * Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
 * lowVal = 20, highVal = 20
 * Output: arr[] = {1, 14, 5, 4, 2, 1, 3, 20, 20, 98, 87, 32, 54}
 */
public class ThreeWayPartition {


    // Partitions arr[0..n-1] around [lowVal..highVal]
    public static void partition(int[] arr, int lowVal, int highVal) {


        // Initialize ext available positions for
        // smaller (than range) and greater elements
        int start = 0;
        int end = arr.length - 1;

        // Traverse elements from left
        for (int i = 0; i < end; ) {

            // If current element is smaller than
            // range, put it on next available smaller
            // position.
            if (arr[i] < lowVal) {

                swap(i, start, arr);
                start++;
                i++;
            }

            // If current element is greater than
            // range, put it on next available greater
            // position.
            else if (arr[i] > highVal) {

                swap(i, end, arr);
                end--;

            } else
                i++;
        }

    }

    private static void swap(int aIndex, int bIndex, int[] array) {
        var temp = array[bIndex];
        array[bIndex] = array[aIndex];
        array[aIndex] = temp;
    }


    public static void main(String[] args) {

        int[] array = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        partition(array, 14, 20);

        for (Integer item : array) {
            System.out.print(item + " ");
        }
    }

}
