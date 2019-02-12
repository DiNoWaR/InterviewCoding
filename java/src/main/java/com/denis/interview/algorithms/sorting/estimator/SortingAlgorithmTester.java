package com.denis.interview.algorithms.sorting.estimator;

import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class SortingAlgorithmTester {

    public static void estimateTime(SortingAlgorithm algorithm, int[] sourceArray) {

        var copiedArray = copyArray(sourceArray);

        var start = System.currentTimeMillis();
        algorithm.sort(copiedArray);
        var end = System.currentTimeMillis();

        System.out.println("Estimated time sorting of |" + sourceArray.length + "| elements by " + algorithm.getName() + " :|" + (end - start) + "| ms");
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    private static int[] copyArray(int[] sourceArray) {

        var resultArray = new int[sourceArray.length];
        System.arraycopy(sourceArray, 0, resultArray, 0, sourceArray.length);
        return resultArray;
    }

}
