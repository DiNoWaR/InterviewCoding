package com.denis.interview.algorithms.sorting.estimator;

import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class SortingAlgorithmEstimateTester {

    public static void estimateTimeOfSorting(SortingAlgorithm algorithm, int[] sourceArray) {

        int[] copiedArray = copyArray(sourceArray);

        long start = System.currentTimeMillis();
        algorithm.sort(copiedArray);
        long end = System.currentTimeMillis();

        System.out.println("Estimated time sorting of |" + sourceArray.length + "| elements by " + algorithm.getName() + " :|" + (end - start) + "| ms");
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    private static int[] copyArray(int[] sourceArray) {

        int[] resultArray = new int[sourceArray.length];
        System.arraycopy(sourceArray, 0, resultArray, 0, sourceArray.length);
        return resultArray;
    }

}
