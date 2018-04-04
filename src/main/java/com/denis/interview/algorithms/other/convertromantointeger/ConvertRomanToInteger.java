package com.denis.interview.algorithms.other.convertromantointeger;

/**
 * Given an string in roman no format (s)  your task is to convert it to integer .
 */
public class ConvertRomanToInteger {

    private static int value(char roman) {

        roman = Character.toUpperCase(roman);

        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    private static boolean validateRoman(String roman) {

        var count = 0;

        var array = roman.toCharArray();

        for (var i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                count++;

                if (count == 3) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }


    public static int convertRomanToInteger(String str) {

        if (!validateRoman(str)) {
            return -1;
        }

        var result = 0;

        for (var i = 0; i < str.length(); i++) {

            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if (s1 >= s2) {
                    result = result + s1;
                } else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        var romanInteger = "XIV";
        System.out.println(convertRomanToInteger(romanInteger));
    }

}
