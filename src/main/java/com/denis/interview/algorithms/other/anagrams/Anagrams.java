package com.denis.interview.algorithms.other.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function that checks if the second string is anagram of the first string
 */
public class Anagrams {

    public boolean checkString(String source, String result) {

        if (source.length() != result.length()) {
            return false;
        }

        if (source.equals(result)) {
            return true;
        }

        boolean isAnagram = true;

        Map<Character, Integer> map = new HashMap<>();

        for (char item : source.toCharArray()) {

            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        for (char item : result.toCharArray()) {

            if (map.containsKey(item)) {
                map.put(item, map.get(item) - 1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }

    public boolean checkStringWithSorting(String source, String result) {

        char[] sourceArray = source.toCharArray();
        char[] resulttArray = result.toCharArray();

        Arrays.sort(sourceArray);
        Arrays.sort(resulttArray);

        return Arrays.equals(sourceArray, resulttArray);
    }


    public static void main(String[] args) {

        Anagrams anagrams = new Anagrams();

        System.out.println(anagrams.checkString("DOG", "GOD"));
        System.out.println(anagrams.checkString("LBABL", "BBAMM"));

        System.out.println(anagrams.checkStringWithSorting("DOG", "GOD"));
        System.out.println(anagrams.checkStringWithSorting("LBABL", "LLLLL"));

    }
}
