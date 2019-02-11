package com.denis.interview.algorithms.arrays.majorityelement;

/**
 * Majority Element: Find an value such that the value represents a majority of the elements in the positive integer
 * array. Return -1 if there is no such element.
 * <p>
 * Assumptions:
 * majority means > array.length / 2
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MajorityElement {


    public static int findMajority(int[] array) {

        int maybeMajority = findPossibleMajority(array);

        if (maybeMajority > 0 && isValidMajority(maybeMajority, array)) {
            return maybeMajority;
        } else {
            return -1;
        }
    }

    private static int findPossibleMajority(final int[] array) {

        int maybeMajority = -1;
        int majorityCount = 0;

        for (int i = 0; i < array.length; i++) {

            if (majorityCount == 0) {
                maybeMajority = array[i];
            }

            if (maybeMajority == array[i]) {
                majorityCount++;
            } else {
                majorityCount--;
            }
        }
        return maybeMajority;
    }

    private static boolean isValidMajority(final int maybeMajority, final int[] array) {

        int counter = 0;

        for (int next : array) {

            if (next == maybeMajority) {
                counter++;

                if (counter > array.length / 2) {
                    return true;
                }
            }
        }
        return false;
    }

}
