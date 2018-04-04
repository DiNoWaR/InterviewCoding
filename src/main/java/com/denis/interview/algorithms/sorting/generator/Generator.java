package com.denis.interview.algorithms.sorting.generator;

import java.util.Random;

public class Generator {

    public static int[] generateArray(int size, int range) {

        var random = new Random();

        var array = new int[size];

        for (var i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

}
