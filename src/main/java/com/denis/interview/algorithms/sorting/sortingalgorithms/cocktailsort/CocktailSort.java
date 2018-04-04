package com.denis.interview.algorithms.sorting.sortingalgorithms.cocktailsort;

import com.denis.interview.algorithms.sorting.enums.SortingAlgorithmNames;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class CocktailSort implements SortingAlgorithm {

    @Override
    public String getName() {
        return SortingAlgorithmNames.COCKTAIL_SORT.getValue();
    }

    @Override
    public void sort(int[] array) {

        var left = 0;
        var right = array.length - 1;

        while (left < right) {

            forward(left, right, array);
            right--;

            backward(left, right, array);
            left++;
        }

    }

    private void forward(int start, int end, int[] array) {
        for (var i = start; i <= end - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(i, i + 1, array);
            }
        }
    }

    private void backward(int start, int end, int[] array) {
        for (var i = end; i >= start + 1; i--) {
            if (array[i] < array[i - 1]) {
                swap(i, i - 1, array);
            }
        }
    }

    private void swap(int aIndex, int bIndex, int[] array) {
        var temp = array[bIndex];
        array[bIndex] = array[aIndex];
        array[aIndex] = temp;
    }

}
