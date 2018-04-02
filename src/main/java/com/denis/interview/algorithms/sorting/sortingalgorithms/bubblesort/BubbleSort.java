package com.denis.interview.algorithms.sorting.sortingalgorithms.bubblesort;


import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;
import com.denis.interview.algorithms.sorting.enums.SortingAlgorithmNames;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        bubbleSort(array);
    }

    @Override
    public String getName() {
        return SortingAlgorithmNames.BUBBLE_SORT.getValue();
    }


    private void bubbleSort(int[] sourceArray) {

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
