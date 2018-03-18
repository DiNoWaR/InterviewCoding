package com.denis.interview.algorithms.interviewcake.productofnumbers;

import java.util.Arrays;
import java.util.Random;

/**
 * You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
 * <p>
 * Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
 * <p>
 * For example, given:
 * <p>
 * [1, 7, 3, 4]
 * <p>
 * your method would return:
 * <p>
 * [84, 12, 28, 21]
 * <p>
 * by calculating:
 * <p>
 * [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
 * <p>
 * Do not use division in your solution
 */
public class ProductOfOtherNumbers {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsOfAllIntsExceptAtIndex;
    }


    public static void main(String[] args) {

        int[] input = {1, 7, 3, 4};
        int[] input2 = {1, 2, 6, 5, 9};
        int[] input3 = {1, 2, 0, 5, 9};

        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(input)));
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(input2)));
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(input3)));
    }
}
