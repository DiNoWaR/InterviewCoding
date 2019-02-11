package com.denis.interview.algorithms.arrays.wavearray;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, sort the array into a wave like array.
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
 * Examples:
 * <p>
 * Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 * Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
 * {20, 5, 10, 2, 80, 6, 100, 3} OR
 * any other array that is in wave form
 * <p>
 * Input:  arr[] = {20, 10, 8, 6, 4, 2}
 * Output: arr[] = {20, 8, 10, 4, 6, 2} OR
 * {10, 8, 20, 2, 6, 4} OR
 * any other array that is in wave form
 * <p>
 * Input:  arr[] = {2, 4, 6, 8, 10, 20}
 * Output: arr[] = {4, 2, 8, 6, 20, 10} OR
 * any other array that is in wave form
 * <p>
 * Input:  arr[] = {3, 6, 5, 10, 7, 20}
 * Output: arr[] = {6, 3, 10, 5, 20, 7} OR
 * any other array that is in wave form
 */
public class WaveArray {


    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //first solution
    public static void sortInWaveWithSorting(int arr[]) {

        Arrays.sort(arr);

        // Swap adjacent elements
        for (int i = 0; i < arr.length - 1; i += 2)
            swap(arr, i, i + 1);
    }

    //second solution
    public static void sortInWave(int arr[]) {

        // Traverse all even elements
        for (int i = 0; i < arr.length; i += 2) {

            // If current even element is smaller
            // than previous
            if (i > 0 && arr[i - 1] > arr[i]) {
                swap(arr, i - 1, i);
            }

            // If current even element is smaller
            // than next
            if (i < arr.length - 1 && arr[i] < arr[i + 1])
                swap(arr, i, i + 1);
        }
    }


    public static void main(String[] args) {

        int first[] = {10, 90, 49, 2, 1, 5, 23};

        sortInWaveWithSorting(first);

        for (int item : first) {
            System.out.print(item + " ");
        }


        int second[] = {10, 90, 49, 2, 1, 5, 23};

        sortInWave(second);

        System.out.println();

        for (int item : second) {
            System.out.print(item + " ");
        }

    }

}
