package com.denis.interview.algorithms.sorting.launch;


import com.denis.interview.algorithms.sorting.sortingalgorithms.bubblesort.BubbleSortingAlgorithm;
import com.denis.interview.algorithms.sorting.sortingalgorithms.combsort.CombSortingAlgorithm;
import com.denis.interview.algorithms.sorting.sortingalgorithms.selectionsort.SelectionSortingAlgorithm;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;
import com.denis.interview.algorithms.sorting.estimator.SortingAlgorithmEstimateTester;
import com.denis.interview.algorithms.sorting.generator.Generator;

public class Launcher {

    private static final int SIZE = 100000;
    private static final int RANGE = 100000;

    public static void main(String[] args) {

        int[] sourceArray = Generator.generateArray(SIZE, RANGE);

        SortingAlgorithm bubble = new BubbleSortingAlgorithm();
        SortingAlgorithm selection = new SelectionSortingAlgorithm();
        SortingAlgorithm comb = new CombSortingAlgorithm();

        SortingAlgorithmEstimateTester.estimateTimeOfSorting(bubble, sourceArray);
        SortingAlgorithmEstimateTester.estimateTimeOfSorting(selection, sourceArray);
        SortingAlgorithmEstimateTester.estimateTimeOfSorting(comb, sourceArray);

    }
}
