package com.denis.interview.algorithms.other.knuthshuffle;

/**
 * Implement the Knuth shuffle for an array
 */
public class KnuthShuffle<T> {


    public void shuffle(T[] array) {

        for (int i = 0; i < array.length; i++) {

            int currentIndex = (int) (Math.random() * (i + 1));
            swap(array, currentIndex, i);
        }
    }

    private void swap(T[] array, int from, int to) {

        T temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }


    public static void main(String[] args) {

        KnuthShuffle<Integer> knuthShuffle = new KnuthShuffle<>();

        Integer[] array = {1, 2, 3, 4, 5};
        knuthShuffle.shuffle(array);

        for (Integer item : array) {
            System.out.print(item + " ");
        }

    }

}
