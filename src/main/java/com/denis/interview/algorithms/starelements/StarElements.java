package com.denis.interview.algorithms.starelements;

import java.util.Arrays;

/**
 * Given an unsorted array. The task is to find all the star and super star elements in the array.
 * Star are those elements which are strictly greater than all the elements on its right side.
 * Super star are those elements which are strictly greater than all the elements on its left and right side.
 */
public class StarElements {

    private static int findSuperStar(int[] arr) {
        int superStar = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                superStar = arr[i + 1];
            }
        }
        if (!isSuperStarUnique(arr, superStar)) {
            return -1;
        }

        return superStar;
    }

    private static boolean isSuperStarUnique(int[] arr, int superStar) {
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        Arrays.sort(arr2);
        if (arr2[arr2.length - 1] == arr2[arr2.length - 2]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,3,5,11,4334,545,4334,1};
        int[] arr2 = {1,9,3,5,11,4334,545,1};
        System.out.println(findSuperStar(arr));
        System.out.println(findSuperStar(arr2));
    }
}

