package com.denis.interview.algorithms.sorting.sortingalgorithms.bubblesort;


import com.denis.interview.algorithms.sorting.enums.SortingAlgorithmNames;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public String getName() {
        return SortingAlgorithmNames.BUBBLE_SORT.getValue();
    }

    @Override
    public void sort(int[] sourceArray) {

        boolean changed = true;

        while (changed) {

            changed = false;

            for (int i = 0; i < sourceArray.length - 1; i++) {

                if (sourceArray[i] > sourceArray[i + 1]) {
                    swap(i, i + 1, sourceArray);
                    changed = true;
                }
            }
        }
    }

    private void swap(int aIndex, int bIndex, int[] array) {
        int temp = array[bIndex];
        array[bIndex] = array[aIndex];
        array[aIndex] = temp;
    }

}
