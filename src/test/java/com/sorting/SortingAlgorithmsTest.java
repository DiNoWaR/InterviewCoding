package com.sorting;


import com.denis.interview.algorithms.sorting.sortingalgorithms.sortingalgorithm.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

public class SortingAlgorithmsTest {

    private static Collection<String> data() {
        return Arrays.asList("com.denis.interview.algorithms.sorting.sortingalgorithms.bubblesort.BubbleSort"
                , "com.denis.interview.algorithms.sorting.sortingalgorithms.cocktailsort.CocktailSort"
                , "com.denis.interview.algorithms.sorting.sortingalgorithms.insertionsort.InsertionSort"
                , "com.denis.interview.algorithms.sorting.sortingalgorithms.selectionsort.SelectionSort"
                , "com.denis.interview.algorithms.sorting.sortingalgorithms.combsort.CombSort"
                , "com.denis.interview.algorithms.sorting.sortingalgorithms.gnomesort.GnomeSort");
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void sortingTwoElements(String algorithmName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class sortingAlgorithmClass = Class.forName(algorithmName);
        Object ob = sortingAlgorithmClass.newInstance();
        SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) ob;

        int[] sourceArray = {12, 5};
        int[] expectedArray = {5, 12};

        sortingAlgorithm.sort(sourceArray);
        Assertions.assertArrayEquals(sourceArray, expectedArray);
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void sortingSimpleCase(String algorithmName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class sortingAlgorithmClass = Class.forName(algorithmName);
        Object ob = sortingAlgorithmClass.newInstance();
        SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) ob;

        int[] sourceArray = {12, 5, 0, -1, 7, 2, 3};
        int[] expectedArray = {-1, 0, 2, 3, 5, 7, 12};

        sortingAlgorithm.sort(sourceArray);
        Assertions.assertArrayEquals(sourceArray, expectedArray);
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void sortingWithRepetitions(String algorithmName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class sortingAlgorithmClass = Class.forName(algorithmName);
        Object ob = sortingAlgorithmClass.newInstance();
        SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) ob;

        int[] sourceArray = {5, 0, -1, 0, 7, 0, 1, 5};
        int[] expectedArray = {-1, 0, 0, 0, 1, 5, 5, 7};

        sortingAlgorithm.sort(sourceArray);
        Assertions.assertArrayEquals(sourceArray, expectedArray);
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void sortingReversedArray(String algorithmName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class sortingAlgorithmClass = Class.forName(algorithmName);
        Object ob = sortingAlgorithmClass.newInstance();
        SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) ob;

        int[] sourceArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        sortingAlgorithm.sort(sourceArray);
        Assertions.assertArrayEquals(sourceArray, expectedArray);
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void sortingFiftyThousandReversedElements(String algorithmName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class sortingAlgorithmClass = Class.forName(algorithmName);
        Object ob = sortingAlgorithmClass.newInstance();
        SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) ob;

        var size = 50000;

        var sourceArray = new int[size];
        var expectedArray = new int[size];

        var j = 0;

        for (var i = size - 1; i >= 0; i--) {
            sourceArray[j] = i;
            j++;
        }

        for (var i = 0; i < size; i++) {
            expectedArray[i] = i;
        }

        sortingAlgorithm.sort(sourceArray);
        Assertions.assertArrayEquals(sourceArray, expectedArray);
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void sortingWithEdgeElements(String algorithmName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class sortingAlgorithmClass = Class.forName(algorithmName);
        Object ob = sortingAlgorithmClass.newInstance();
        SortingAlgorithm sortingAlgorithm = (SortingAlgorithm) ob;

        var sourceArray = new int[]{10, 0, 0, 0, 5, 0, 0, 0, 0, -1};
        var expectedArray = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 5, 10};

        sortingAlgorithm.sort(sourceArray);
        Assertions.assertArrayEquals(sourceArray, expectedArray);
    }

}
