package com.denis.interview.algorithms.arrays.countnonzero;

/**
 * Implement function that counts none zerp elements in array and shifts all zeroes to the right
 */
public class CountNoneZero {


    public static int countNoneZeroElementsAndShiftZeroes(int[] array) {

        int rightBorder = array.length - 1;

        for (int i = 0; i < rightBorder; i++) {

            if (array[i] == 0) {

                if (array[rightBorder] == 0) {
                    rightBorder = updateRightBorder(array, rightBorder);
                    swap(array, i, rightBorder);
                }
            }

        }

        return array.length - rightBorder + 1;
    }


    private static void swap(int[] array, int fromIndex, int toIndex) {

        int temp = array[toIndex];
        array[toIndex] = array[fromIndex];
        array[fromIndex] = temp;

    }

    private static int updateRightBorder(int[] array, int rightIndex) {

        int result = 0;

        for (int i = rightIndex; i > 0; i--) {

            if (array[i] != 0) {
                result = i;
                break;
            }
        }

        return result;

    }


    public static void main(String[] args) {

        int[] array = {0, 1, 0, 3, 5, 10, 0};

        System.out.println(countNoneZeroElementsAndShiftZeroes(array));

        for (int item : array) {
            System.out.print(item + " ");
        }

    }
}
