package com.denis.interview.algorithms.arrays.arrayleftrotation;

import java.util.Arrays;

/**
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left.
 * For example, if  left rotations are performed on array , then the array would become .
 * Given an array of  integers and a number, , perform  left rotations on the array.
 * Then print the updated array as a single line of space-separated integers.
 * Sample Input
 * 1 2 3 4 5 and shift 4
 * Sample Output
 * 5 1 2 3 4
 * Explanation
 * When we perform  left rotations, the array undergoes the following sequence of changes:
 * Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 */
public class ArrayLeftRotation {

    public static int[] rotateArray(int[] array, int shift) {

        int[] target = new int[array.length];

        for (int i = 0; i < target.length; i++) {

            int targetIndex = i - shift;

            if (targetIndex < 0) {
                targetIndex = array.length + targetIndex;
            }
            target[targetIndex] = array[i];
        }
        return target;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(rotateArray(array, 4)));

    }

}
