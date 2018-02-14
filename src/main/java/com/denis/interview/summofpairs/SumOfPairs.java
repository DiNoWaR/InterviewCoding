package com.denis.interview.summofpairs;

import java.util.Arrays;

public class SummOfPairs {


    public int countPairsOfElementsInArray(int[] array, int target) {

        int count = 0;

        Arrays.sort(array);
        int targetIndex = Arrays.binarySearch(array, target);

        if (targetIndex == -1) {
            return 0;
        }

        for (int i = 0; i <= targetIndex; i++) {
            int j = targetIndex;
        }

        return count;
    }

    private boolean checkSum(int first, int second, int target) {
        return first + second == target;
    }

}
