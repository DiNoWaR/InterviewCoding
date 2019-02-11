package com.denis.interview.algorithms.sorting.enums;

public enum SortingAlgorithmNames {

    BUBBLE_SORT("Bubble Sort Algorithm"),
    INSERTION_SORT("Insertion Sort Algorithm"),
    SELECTION_SORT("Selection Sort Algorithm"),
    COMB_SORT("Comb Sort Algorithm"),
    COCKTAIL_SORT("Cocktail Sort Algorithm"),
    GNOME_SORT("Gnome Sort Algorithm");

    private String value;

    SortingAlgorithmNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
