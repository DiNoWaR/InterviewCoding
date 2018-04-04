package com.denis.interview.algorithms.sorting.launch;


import com.denis.interview.algorithms.sorting.estimator.SortingAlgorithmTester;
import com.denis.interview.algorithms.sorting.generator.Generator;
import com.denis.interview.algorithms.sorting.sortingalgorithms.bubblesort.BubbleSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.cocktailsort.CocktailSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.combsort.CombSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.gnomesort.GnomeSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.insertionsort.InsertionSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.selectionsort.SelectionSort;
import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;

public class Launcher {

    private static final int SIZE = 100000;
    private static final int RANGE = 100000;

    public static void main(String[] args) {

        int[] sourceArray = Generator.generateArray(SIZE, RANGE);

        var bubble = new BubbleSort();
        var cocktail = new CocktailSort();
        var gnome = new GnomeSort();
        var insertion = new InsertionSort();
        var selection = new SelectionSort();
        var comb = new CombSort();

        SortingAlgorithmTester.estimateTimeOfSorting(bubble, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(cocktail, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(gnome, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(insertion, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(selection, sourceArray);
        SortingAlgorithmTester.estimateTimeOfSorting(comb, sourceArray);

    }
}
