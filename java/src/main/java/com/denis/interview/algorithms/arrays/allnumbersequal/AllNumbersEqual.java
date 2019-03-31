package com.denis.interview.algorithms.arrays.allnumbersequal;

/**
 * Given an array arr[], the task is to make all the array elements equal with the given operation.
 * In a single operation, any element of the array can be either multiplied by 2 or by 3.
 * If its possible to make all the array elements equal with the given operation then print Yes else print No.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {50, 75, 100}
 * Output: Yes
 * <p>
 * {50 * 2 * 3, 75 * 2 * 2, 100 * 3} = {300, 300, 300}
 * <p>
 * Input: arr[] = {10, 14}
 * Output: No
 */
public class AllNumbersEqual {


    public static boolean equalNumbers(int[] array) {

        for (int i = 0; i < array.length; i++) {

            // Divide number by 2
            while (array[i] % 2 == 0) {
                array[i] /= 2;
            }

            // Divide number by 3
            while (array[i] % 3 == 0) {
                array[i] /= 3;
            }
        }

        // Remaining numbers
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[0]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        int a[] = {50, 75, 150};

        if (equalNumbers(a)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}


