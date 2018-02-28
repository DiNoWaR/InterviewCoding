package com.denis.interview.deutschebank;

public class DBExampleOne {

    public static <T> T foo() {
        try {
            return (T) new Integer(42);
        } catch (ClassCastException e) {
            return (T) "Deutsche Bank";
        }
    }

    public static void main(String[] args) {
        System.out.println(DBExampleOne.<String>foo());
    }

}
