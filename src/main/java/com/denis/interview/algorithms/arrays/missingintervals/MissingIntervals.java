package com.denis.interview.algorithms.arrays.missingintervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array A of integers  from 0 to 99 (repetition of elements allowed),
 * output all the integer intervals missing from the given list.
 * <p>
 * Input:  1 5 67 88
 * Output: 0,2-4,6-66,68-87,89-99
 * ------------------------------
 * Input:  4 55 77 89 91 99
 * Output: 0-3,5-54,56-76,78-88,90,92-98
 * ------------------------------
 * Input:  0 3 4 6 80 90 91
 * Output: 1-2,5,7-79,81-89,92-99
 * <p>
 * Constraints:
 * 1<=N<=100
 * <p>
 */
public class MissingIntervals {

    private final static int MAX = 99;

    public static List<String> getIntervals(int[] array) {

        List<String> intervals = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++) {
            String interval;

            if (i == 0) {

                if (array[i] > 0) {

                    if (array[i] == 1) {
                        interval = "0";
                        intervals.add(interval);
                    } else {
                        interval = buildInterval(-1, array[i]);
                        intervals.add(interval);
                    }
                }
            }

            interval = buildInterval(array[i], array[i + 1]);

            if (!"".equals(interval)) {
                intervals.add(interval);
            }

            if (i == array.length - 2) {
                if (array[i + 1] == MAX) {

                } else if (array[i + 1] == MAX - 1) {
                    intervals.add(Integer.toString(MAX));
                } else {
                    interval = buildInterval(array[i + 1], MAX + 1);
                    intervals.add(interval);
                }
            }
        }
        return intervals;
    }

    private static String buildInterval(int from, int to) {

        if ((to - from) > 2) {
            return Integer.toString(from + 1) + "-" + Integer.toString(to - 1);
        }

        if ((to - from) == 2) {
            return Integer.toString(from + 1);
        }

        return "";
    }

    public static void main(String[] args) {

        int[] array1 = {1, 5, 67, 88};
        int[] array2 = {4, 55, 77, 89, 91, 99};
        int[] array3 = {0, 3, 4, 6, 80, 90, 91};

        System.out.println(getIntervals(array1));
        System.out.println(getIntervals(array2));
        System.out.println(getIntervals(array3));

    }

}
