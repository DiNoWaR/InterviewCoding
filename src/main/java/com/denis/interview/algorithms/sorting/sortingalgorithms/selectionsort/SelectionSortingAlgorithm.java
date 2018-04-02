package com.denis.interview.algorithms.sorting.sortingalgorithms.selectionsort;


import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;
import com.denis.interview.algorithms.sorting.enums.AlgorithmNames;

public class SelectionSortingAlgorithm implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        selectionSort(array);
    }

    @Override
    public String getName() {
        return AlgorithmNames.SELECTION_SORT.getValue();
    }


    private void selectionSort(int[] array) {

        int left = 0;

        while (left < array.length) {

            int indexOfMinElement = findIndexOfMinElement(array, left);
            swap(left, indexOfMinElement, array);
            left++;
        }
    }

    private int findIndexOfMinElement(int[] array, int startIndex) {

        int indexOfMinElement = startIndex;

        int min = array[startIndex];

        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexOfMinElement = i;
            }
        }
        return indexOfMinElement;
    }

    private void swap(int aIndex, int bIndex, int[] array) {
        int temp = array[bIndex];
        array[bIndex] = array[aIndex];
        array[aIndex] = temp;
    }

}
