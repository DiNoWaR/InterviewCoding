package com.denis.interview.uniqueelementsinarrays;

import java.util.*;

/**
 * Find unique items from two arrays
 */
public class ArrayWorker {

    public List<Integer> getUniqueElementsOfArraysWithSorting(int[] first, int[] second) {

        ArrayList<Integer> result = new ArrayList<>(first.length + second.length);

        Arrays.sort(first);
        Arrays.sort(second);

        for (Integer item : first) {

            Integer searchingElementIndex = Arrays.binarySearch(second, item);

            if (searchingElementIndex == -1) {
                result.add(item);
            }
        }

        result.trimToSize();

        return result;
    }

    public List<Integer> getUniqueElementsOfArraysWithMap(int[] first, int[] second) {

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

}
