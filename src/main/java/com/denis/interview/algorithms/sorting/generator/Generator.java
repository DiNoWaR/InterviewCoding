package com.denis.interview.algorithms.sorting.generator;

import java.util.Random;

public class Generator {

    public static int[] generateArray(int size, int range) {

        Random random = new Random();

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

}
