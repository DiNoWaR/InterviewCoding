package com.denis.interview.algorithms.arrays.uniqueelements;

import java.util.*;

/**
 * Find unique items from two arrays (Element is only in one array)
 */
public class ArrayWorker {

    public static List<Integer> getUniqueElementsOfArraysWithSorting(int[] first, int[] second) {

        ArrayList<Integer> result = new ArrayList<>(first.length + second.length);

        Arrays.sort(first);
        Arrays.sort(second);

        for (Integer item : first) {

            Integer searchingElementIndex = Arrays.binarySearch(second, item);

            if (searchingElementIndex < 0) {
                result.add(item);
            }
        }


        for (Integer item : second) {

            Integer searchingElementIndex = Arrays.binarySearch(first, item);

            if (searchingElementIndex < 0) {
                result.add(item);
            }
        }

        result.trimToSize();

        return result;
    }

    public static List<Integer> getUniqueElementsOfArraysWithMap(int[] first, int[] second) {

        Map<Integer, Integer> values = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>(first.length + second.length);

        for (int i = 0; i < first.length; i++) {
            values.put(i, values.get(i) == null ? values.get(i) : values.get(i) + 1);
        }

        for (int i = 0; i < second.length; i++) {
            values.put(i, values.get(i) == null ? values.get(i) : values.get(i) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {

            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        result.trimToSize();
        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 4, 6, 10, 60};
        int[] arr2 = {6, 8, 2, 10};

        List<Integer> result = getUniqueElementsOfArraysWithSorting(arr1, arr2);
        List<Integer> result2 = getUniqueElementsOfArraysWithMap(arr1, arr2);

        System.out.println(result);
        System.out.println(result2);

    }
}
