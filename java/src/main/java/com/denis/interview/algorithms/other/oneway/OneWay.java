package com.denis.interview.algorithms.other.oneway;


public class OneWay {

    public boolean checkString(String src, String target) {

        if (Math.abs(src.length() - target.length()) >= 2) {
            return false;
        }

        if (src.equals(target)) {
            return true;
        }

        if (src.length() == target.length()) {

            int counter = 0;

            for (int i = 0; i < src.length(); i++) {
                if (src.charAt(i) != target.charAt(i)) {
                    counter++;
                }
            }
            return counter == 1;
        }

        String longString = src;
        String shortString = target;

        if (src.length() < target.length()) {
            longString = target;
            shortString = src;
        }
        int k = 0;
        int counter = 0;

        for (int i = 0; i < longString.length(); i++) {
            if (counter == 0 && i == longString.length() - 1) {
                return true;
            }
            if (src.charAt(i) != shortString.charAt(k)) {
                counter++;
            } else {
                k++;
            }
        }
        if (counter < 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        OneWay oneWay = new OneWay();
        System.out.println(oneWay.checkString("bugaga", "bugag"));
        System.out.println(oneWay.checkString("bugaga", "bugaga"));
        System.out.println(oneWay.checkString("bugaga", "bugapa"));
        System.out.println(oneWay.checkString("bugaga", "buaga"));
        System.out.println(oneWay.checkString("bugaga", "ugaga"));
        System.out.println(oneWay.checkString("bugaga", "bumaga"));
        System.out.println(oneWay.checkString("", "1"));
        System.out.println(oneWay.checkString("1", ""));
        System.out.println("-----------------------------------------------------");
        System.out.println(oneWay.checkString("bugaga", "bugggg"));
        System.out.println(oneWay.checkString("bugaga", "alalot"));
        System.out.println(oneWay.checkString("bugaga", "bugggg"));
        System.out.println(oneWay.checkString("bugaga", "jkgfdslgj"));
        System.out.println(oneWay.checkString("bugaga", "abugag"));
        System.out.println(oneWay.checkString("32", ""));
    }
}
