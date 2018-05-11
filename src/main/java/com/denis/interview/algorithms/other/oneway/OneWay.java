package com.denis.interview.algorithms.other.oneway;

public class OneWay {

    public boolean checkString(String src, String target) {

        if (Math.abs(src.length() - target.length()) > 2) {
            return false;
        }

        if (src.equals(target)) {
            return true;
        }


    }

}
