package com.denis.interview.algorithms.arrays.sortbyfrequency;

import java.util.*;

/**
 * Given an integer array, sort the array according to the frequency of elements in decreasing order, if frequency of two elements are same then sort in increasing order
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}
 * Output: 3 3 3 3 2 2 2 12 12 4 5
 * Explanation :
 * No. Freq
 * 2  : 3
 * 3  : 4
 * 4  : 1
 * 5  : 1
 * 12 : 2
 * <p>
 * Input: arr[] = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5}
 * Output: 2 2 2 2 1 1 3 3 4 4 5 6 7
 */
public class SortByFrequency {


    public static List<Integer> sortByFrequency(int[] array) {


        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();


        for (Integer item : array) {
            result.add(item);
            int count = map.getOrDefault(item, 0);
            map.put(item, count + 1);
        }

        Collections.sort(result, new SortComparator(map));

        return result;
    }


    public static void main(String[] args) {

        int[] array = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};

        List<Integer> sorted = sortByFrequency(array);

        for (Integer item : sorted) {
            System.out.print(item + " ");
        }


    }

}
