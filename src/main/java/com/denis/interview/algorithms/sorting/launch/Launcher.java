package com.denis.interview.algorithms.sorting.launch;


import com.denis.interview.algorithms.sorting.sortingalgorithms.bubblesort.BubbleSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.cocktailsort.CocktailSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.combsort.CombSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.selectionsort.SelectionSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;
import com.denis.interview.algorithms.sorting.estimator.SortingAlgorithmTester;
import com.denis.interview.algorithms.sorting.generator.Generator;

public class Launcher {

    private static final int SIZE = 100000;
    private static final int RANGE = 100000;

    public static void main(String[] args) {

        int[] sourceArray = Generator.generateArray(SIZE, RANGE);

        SortingAlgorithm bubble = new BubbleSort();
        SortingAlgorithm cocktail = new CocktailSort();
        SortingAlgorithm selection = new SelectionSort();
        SortingAlgorithm comb = new CombSort();

        SortingAlgorithmTester.estimateTimeOfSorting(bubble, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(cocktail, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(selection, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(comb, sourceArray);

    }
}
