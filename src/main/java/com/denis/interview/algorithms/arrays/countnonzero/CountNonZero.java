package com.denis.interview.algorithms.arrays.countnonzero;

import com.denis.interview.algorithms.sorting.generator.Generator;

public class CountNonZero {

    public int countNonZeroElements(int[] array) {
        int indexFirst = 0;
        int indexSecond = array.length - 1;
        int numberOfZeros = 0;

        for (int item : array) {
            if (item == 0) {
                numberOfZeros++;
            }
        }

        while (indexFirst < array.length) {
            if (array[indexFirst] == 0) {

                while (indexSecond >= 0) {
                    if (array[indexSecond] != 0 && indexSecond > indexFirst) {
                        array[indexFirst] = array[indexSecond];
                        array[indexSecond] = 0;
                        indexSecond--;
                        break;
                    }
                    indexSecond--;
                }
            }
            indexFirst++;
        }
        return numberOfZeros;
    }

    public static void main(String[] args) {

        int[] array1 = Generator.generateArray(1000000, 1);
        CountNonZero countNonZero = new CountNonZero();
        var start = System.currentTimeMillis();
        System.out.println(countNonZero.countNonZeroElements(array1));
        var end = System.currentTimeMillis();
        System.out.println((end - start) + " millis");

    }
}
