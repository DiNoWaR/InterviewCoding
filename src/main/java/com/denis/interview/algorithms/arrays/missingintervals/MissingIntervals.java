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

        var intervals = new ArrayList<String>();

        if (array.length == 1) {
            buildIntervalForOneElement(array, intervals);
            return intervals;
        }

        for (int i = 0; i < array.length - 1; i++) {
            var interval = "";

            if (i == 0) {
                buildHead(array, intervals);
            }

            interval = buildInterval(array[i], array[i + 1]);

            if (!"".equals(interval)) {
                intervals.add(interval);
            }

            if (i == array.length - 2) {
                buildTail(array, intervals);
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

    private static void buildHead(int[] array, List<String> intervals) {

        var interval = "";

        if (array[0] > 0) {

            if (array[0] == 1) {
                interval = "0";
            } else {
                interval = buildInterval(-1, array[0]);
            }
            intervals.add(interval);
        }
    }

    private static void buildTail(int[] array, List<String> intervals) {

        var interval = "";

        if (array[array.length - 1] == MAX) {

        } else if (array.length - 1 == MAX - 1) {
            intervals.add(Integer.toString(MAX));
        } else {
            interval = buildInterval(array[array.length - 1], MAX + 1);
            intervals.add(interval);
        }
    }

    private static void buildIntervalForOneElement(int[] array, List<String> intervals) {

        if (array[0] == 0) {
            intervals.add(buildInterval(0, MAX + 1));
        } else if (array[0] == 1) {
            intervals.add(Integer.toString(0));
            intervals.add(buildInterval(1, MAX + 1));
        } else if (array[0] == MAX) {
            intervals.add(buildInterval(-1, MAX));
        } else if (array[0] == MAX - 1) {
            intervals.add(buildInterval(-1, MAX - 1));
            intervals.add(Integer.toString(MAX));
        } else {
            intervals.add(buildInterval(-1, array[0]));
            intervals.add(buildInterval(array[0], MAX + 1));
        }
    }


    public static void main(String[] args) {

        var array1 = new int[]{1, 5, 67, 88};
        var array2 = new int[]{4, 55, 77, 89, 91, 99};
        var array3 = new int[]{0, 3, 4, 6, 80, 90, 91};
        var array4 = new int[]{0};
        var array5 = new int[]{1};
        var array6 = new int[]{99};
        var array7 = new int[]{98};
        var array8 = new int[]{76};

        System.out.println(getIntervals(array1));
        System.out.println(getIntervals(array2));
        System.out.println(getIntervals(array3));
        System.out.println(getIntervals(array4));
        System.out.println(getIntervals(array5));
        System.out.println(getIntervals(array6));
        System.out.println(getIntervals(array7));
        System.out.println(getIntervals(array8));

    }
}
