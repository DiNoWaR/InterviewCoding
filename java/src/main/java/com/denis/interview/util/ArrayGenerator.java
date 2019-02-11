package com.denis.interview.util;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {


    public static Integer[] generateArray(int size, int range, boolean withDubs) {

        Integer[] array = new Integer[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(range);
        }

        if (!withDubs) {
            array = Arrays.stream(array).distinct().toArray(Integer[]::new);
        }

        return array;

    }

}
