package com.denis.interview.algorithms.dynamicprogramming.decodeways;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {


    public static int numDecodings(String s) {

        if (("0".equals(s)) || "".equals(s)) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        } else {

            if (s.length() >= 2) {

                if (Integer.valueOf(s.substring(0, 2)) > 26) {
                    return 1 + numDecodings(s.substring(2));
                } else {
                    return numDecodings(s.substring(0, 1)) + numDecodings(s.substring(1));
                }

            } else {
                return numDecodings(s.substring(0, 1)) + numDecodings(s.substring(1));
            }
        }
    }


    public static void main(String[] args) {

        System.out.println(numDecodings("101"));

    }
}
