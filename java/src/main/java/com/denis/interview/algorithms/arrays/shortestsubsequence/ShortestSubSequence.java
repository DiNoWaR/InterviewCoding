package com.denis.interview.algorithms.arrays.shortestsubsequence;


import java.util.*;

/**
 * You are given two arrays, one shorter (with all distinct elements) and one longer.
 * Find the shortest subarray in the longer array that contains all the elements in the shorter array.
 * The items can appear in any order.
 *
 * <p>
 * Integer[] input = {1, 5, 9};
 * Integer[] source = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
 * <p>
 * Returns [7,10] (indexes of the shortest subsequence)
 */
public class ShortestSubSequence {


    public static Integer[] findShortestSubsequence(Integer[] input, Integer[] source) {

        Set<Integer> inputSet = new HashSet<>(Arrays.asList(input));
        Set<Integer> tempSet = new HashSet<>();

        var left = 0;
        var right = 0;

        List<Integer[]> sequences = new ArrayList<>();


        for (int i = 0; i < source.length; i++) {

            if (inputSet.contains(source[i])) {

                if (tempSet.isEmpty()) {
                    left = i;
                }

                tempSet.add(source[i]);

                if (tempSet.equals(inputSet)) {
                    right = i;
                    tempSet.clear();
                    sequences.add(new Integer[]{left, right});
                }
            }
        }

        Comparator<Integer[]> sequenceComparator = Comparator.comparingInt(s -> s[1] - s[0]);

        return sequences.stream().min(sequenceComparator).orElse(new Integer[]{0, 0});
    }


    public static void main(String[] args) {

        Integer[] input = {1, 5, 9};
        Integer[] source = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};

        System.out.println(Arrays.toString(findShortestSubsequence(input, source)));

    }
}
