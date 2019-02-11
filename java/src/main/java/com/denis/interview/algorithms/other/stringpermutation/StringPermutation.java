package com.denis.interview.algorithms.other.stringpermutation;

import java.util.HashSet;

/**
 * Implement function to check if String has permutation Palindroms (at least one)
 *
 * Input: Taco Cat
 * Output : True (taco cat, atco cta)
 *
 */
public class StringPermutation {

    public boolean checkPalindromPermutation(String src) {

        if (src.length() <= 2) {
            return true;
        }

        HashSet<Character> set = new HashSet<>();

        for (char item : src.toLowerCase().toCharArray()) {

            if (item != ' ') {
                boolean added = set.add(item);

                if (!added) {
                    set.remove(item);
                }
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {

        StringPermutation permutation = new StringPermutation();
        System.out.println(permutation.checkPalindromPermutation("taco cat"));

    }
}
