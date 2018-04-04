package com.denis.interview.algorithms.sorting.sortingalgorithms.selectionsort;

import com.denis.interview.algorithms.sorting.enums.SortingAlgorithmNames;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public String getName() {
        return SortingAlgorithmNames.SELECTION_SORT.getValue();
    }

    @Override
    public void sort(int[] array) {
        var left = 0;

        while (left < array.length) {

            var indexOfMinElement = findIndexOfMinElement(array, left);
            swap(left, indexOfMinElement, array);
            left++;
        }
    }

    private int findIndexOfMinElement(int[] array, int startIndex) {

        var indexOfMinElement = startIndex;

        var min = array[startIndex];

        for (var i = startIndex; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexOfMinElement = i;
            }
        }
        return indexOfMinElement;
    }

    private void swap(int aIndex, int bIndex, int[] array) {
        var temp = array[bIndex];
        array[bIndex] = array[aIndex];
        array[aIndex] = temp;
    }

}
