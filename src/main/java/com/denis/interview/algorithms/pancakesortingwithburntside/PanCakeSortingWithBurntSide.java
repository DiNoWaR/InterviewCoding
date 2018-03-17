package com.denis.interview.algorithms.pancakesortingwithburntside;

public class PanCakeSortingWithBurntSide {


    public static void panCakeSortWithBurntSide(PanCake[] array) {

        int j = 1;

        while (j <= array.length - 1) {

            int indexOfMax = findIndexOfMaximum(array, array.length - j);

            flip(array, indexOfMax);

            if (array[0].isBurntSideDown()) {
                flip(array, 0);
            }

            flip(array, array.length - j);

            j++;
        }
        if (!array[0].isBurntSideDown()) {
            flip(array, 0);
        }
    }

    private static void flip(PanCake[] array, int index) {

        int left = 0;
        int right = index;

        while (left <= right) {
            swap(left, right, array);
            left++;
            right--;
        }

        for (int i = 0; i <= index; i++) {
            if (array[i].isBurntSideDown()) {
                array[i].setBurntSideDown(false);
            } else {
                array[i].setBurntSideDown(true);
            }
        }

    }

    private static void swap(int sourceIndex, int targetIndex, PanCake[] array) {
        PanCake temp = array[targetIndex];
        array[targetIndex] = array[sourceIndex];
        array[sourceIndex] = temp;
    }

    private static int findIndexOfMaximum(PanCake[] array, int rightIndex) {

        int max = 0;

        for (int i = 0; i <= rightIndex; i++) {
            if (array[i].getSize() > array[max].getSize()) {
                max = i;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        PanCake[] panCakes = new PanCake[13];

        panCakes[0] = new PanCake(5, false);
        panCakes[1] = new PanCake(1, false);
        panCakes[2] = new PanCake(7, true);
        panCakes[3] = new PanCake(10, true);
        panCakes[4] = new PanCake(3, false);
        panCakes[5] = new PanCake(9, true);
        panCakes[6] = new PanCake(2, false);
        panCakes[7] = new PanCake(8, false);
        panCakes[8] = new PanCake(6, true);
        panCakes[9] = new PanCake(13, true);
        panCakes[10] = new PanCake(12, false);
        panCakes[11] = new PanCake(4, true);
        panCakes[12] = new PanCake(11, true);

        panCakeSortWithBurntSide(panCakes);

        for (PanCake panCake : panCakes) {
            System.out.println(panCake);
        }
    }

}
