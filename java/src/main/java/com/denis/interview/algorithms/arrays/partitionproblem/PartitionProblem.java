package com.denis.interview.algorithms.arrays.partitionproblem;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is same.
 * <p>
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 * <p>
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 */
public class PartitionProblem {


    public static boolean canBeDivided(int[] array) {

        int sum = countSum(array);

        if (sum % 2 != 0) {
            return false;
        }

        return isSubsetSum(array, array.length, sum / 2);

    }

    private static boolean isSubsetSum(int arr[], int n, int sum) {

        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n - 1, sum);

        }

        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    private static int countSum(int[] array) {

        int sum = 0;

        for (int item : array) {
            sum += item;
        }

        return sum;
    }


    public static void main(String[] args) {

        int[] array = {1, 5, 11, 5};
        System.out.println(canBeDivided(array));

    }
}
