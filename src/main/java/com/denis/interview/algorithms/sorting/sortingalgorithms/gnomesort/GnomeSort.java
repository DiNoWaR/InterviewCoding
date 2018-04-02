package com.denis.interview.algorithms.sorting.sortingalgorithms.gnomesort;

import com.denis.interview.algorithms.sorting.enums.SortingAlgorithmNames;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class GnomeSort implements SortingAlgorithm {

    @Override
    public String getName() {
        return SortingAlgorithmNames.GNOME_SORT.getValue();
    }

    @Override
    public void sort(int[] array) {

        int count = 0;

        while (count < array.length - 1) {

            if (array[count] > array[count + 1]) {
                count = reverse(++count, array);
            }
            count++;
        }

    }

    private int reverse(int right, int[] array) {

        int stopIndex = 0;

        for (int i = right; i >= 1; i--) {
            if (array[i] < array[i - 1]) {
                swap(i, i - 1, array);
            } else {
                stopIndex = i;
                break;
            }
        }
        return stopIndex;
    }

    private void swap(int aIndex, int bIndex, int[] array) {
        int temp = array[bIndex];
        array[bIndex] = array[aIndex];
        array[aIndex] = temp;
    }

}
