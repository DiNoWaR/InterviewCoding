package com.denis.interview.algorithms.sorting.enums;

public enum AlgorithmNames {

    BUBBLE_SORT("Bubble Sort Algorithm"),
    INSERTION_SORT("Insertion Sort Algorithm"),
    SELECTION_SORT("Selection Sort Algorithm"),
    COMB_SORT("Comb Sort Algorithm");

    private String value;

    AlgorithmNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
