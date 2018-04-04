package com.denis.interview.java.cloneable;

import java.util.Date;

public class CloneableTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        var denis = new User("Denis", "Vasilyev", new Date());

        var start = System.currentTimeMillis();
        for (var i = 0; i < 2000000; i++) {
            User cloned = (User) denis.clone();
        }
        var end = System.currentTimeMillis();

        System.out.println("User cloned for " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (var i = 0; i < 2000000; i++) {
            User cloned = denis.customClone();
        }
        end = System.currentTimeMillis();

        System.out.println("User custom cloned for " + (end - start) + " ms");

    }
}
