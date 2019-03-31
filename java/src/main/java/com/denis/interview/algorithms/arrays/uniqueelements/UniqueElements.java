package com.denis.interview.algorithms.arrays.uniqueelements;

import com.denis.interview.util.ArrayGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Find unique items from two arrays (Element is only in one array)
 */
public class UniqueElements {

    public static List<Integer> getUniqueElementsOfArraysWithSorting(Integer[] first, Integer[] second) {

        var result = new ArrayList<Integer>(first.length + second.length);

        Arrays.sort(first);
        Arrays.sort(second);

        for (var item : first) {

            Integer searchingElementIndex = Arrays.binarySearch(second, item);

            if (searchingElementIndex < 0) {
                result.add(item);
            }
        }


        for (var item : second) {

            var searchingElementIndex = Arrays.binarySearch(first, item);

            if (searchingElementIndex < 0) {
                result.add(item);
            }
        }

        result.trimToSize();

        return result;
    }

    public static List<Integer> getUniqueElementsOfArraysWithMap(Integer[] first, Integer[] second) {

        var result = new ArrayList<Integer>();

        var bufferSet = new HashSet<>(Arrays.asList(first));

        for (int item : second) {
            if (!bufferSet.contains(item)) {
                result.add(item);
            }
        }

        bufferSet.clear();


        bufferSet.addAll(Arrays.asList(second));

        for (int item : first) {
            if (!bufferSet.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        Integer[] arr1 = ArrayGenerator.generateArray(300000, 190000, false);
        Integer[] arr2 = ArrayGenerator.generateArray(300000, 190000, false);

        long start = System.currentTimeMillis();
        List<Integer> result = getUniqueElementsOfArraysWithSorting(arr1, arr2);
        long end = System.currentTimeMillis();

        System.out.println((end - start) + " ms with Sorting");

        start = System.currentTimeMillis();
        List<Integer> result2 = getUniqueElementsOfArraysWithMap(arr1, arr2);
        end = System.currentTimeMillis();

        System.out.println((end - start) + " ms with HashSet");

    }
}
