package com.denis.interview.missingintervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a sorted array A of integers  from 0 to 99 (repetition of elements allowed), output all the integer intervals missing from the given list.
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

    private static List<String> getMissingIntervals(int[] array) {

        List<String> intervals = new ArrayList<>();

        int maximum = 99;
        int from = 0;

        if (array[0] != 0) {
            String interval = buildInterval(0, array[0]);
            if (!interval.equals("")) {
                intervals.add(interval);
            }
        }

        for (int i = 0; i < array.length - 1; i++) {

            from = array[i];

            String interval = buildInterval(array[i], array[i + 1]);

            if (!interval.equals("")) {
                intervals.add(interval);
            }
        }

        if (from != maximum) {
            String interval = buildInterval(from, maximum);
            intervals.add(interval);
        }
        return intervals;
    }

    private static String buildInterval(int from, int to) {

        int diff = to - from;

        if (from == 0) {
            if (diff == 1) {
                return "0";
            } else {
                return "0" + "-" + Integer.toString(to - 1);
            }
        }

        if (diff == 1) {
            return "";
        }

        if (diff == 2) {
            return Integer.toString(to - 1);
        }

        return Integer.toString(from + 1) + "-" + Integer.toString(to - 1);
    }


    public static void main(String[] args) {

        int[] array = {1, 5, 67, 88};
        int[] array2 = {4, 55, 77, 89, 91, 99};
        int[] array3 = {0, 3, 4, 6, 80, 90, 91};

        System.out.println(getMissingIntervals(array));
        System.out.println(getMissingIntervals(array2));
        System.out.println(getMissingIntervals(array3));

    }

}
