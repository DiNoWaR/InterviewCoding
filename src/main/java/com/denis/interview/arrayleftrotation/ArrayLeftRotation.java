package com.denis.interview.arrayleftrotation;

import java.util.Scanner;

/**
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left.
 * For example, if  left rotations are performed on array , then the array would become .
 * <p>
 * Given an array of  integers and a number, , perform  left rotations on the array.
 * Then print the updated array as a single line of space-separated integers.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
 * The second line contains  space-separated integers describing the respective elements of the array's initial state.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.
 * <p>
 * Sample Input
 * <p>
 * 5 4
 * 1 2 3 4 5
 * Sample Output
 * <p>
 * 5 1 2 3 4
 * Explanation
 * <p>
 * When we perform  left rotations, the array undergoes the following sequence of changes:
 * <p>
 * Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 */
public class ArrayLeftRotation {


    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        return null;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];

        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] output = arrayLeftRotation(a, n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }

        System.out.println();
    }


}
