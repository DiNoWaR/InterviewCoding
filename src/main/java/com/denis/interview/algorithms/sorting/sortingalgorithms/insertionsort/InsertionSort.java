package com.denis.interview.algorithms.sorting.sortingalgorithms.insertionsort;

import com.denis.interview.algorithms.sorting.enums.SortingAlgorithmNames;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public String getName() {
        return SortingAlgorithmNames.INSERTION_SORT.getValue();
    }

    @Override
    public void sort(int[] array) {

        int i, key, j;

        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

}
