package com.denis.interview.algorithms.arrays.sortbyfrequency;

import java.util.Comparator;
import java.util.Map;

public class SortComparator implements Comparator<Integer> {

    private Map<Integer, Integer> frequencyMap;


    public SortComparator(Map<Integer, Integer> map) {
        this.frequencyMap = map;
    }


    @Override
    public int compare(Integer k1, Integer k2) {

        // Compare value by frequency
        int freqCompare = frequencyMap.get(k2).compareTo(frequencyMap.get(k1));

        // Compare value if frequency is equal
        int valueCompare = k1.compareTo(k2);

        // If frequency is equal, then just compare by value, otherwise -
        // compare by the frequency.
        if (freqCompare == 0) {
            return valueCompare;

        } else return freqCompare;
    }
}
