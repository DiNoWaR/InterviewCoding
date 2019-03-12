package com.denis.interview.javacore.hashcodelong;

/**
 * Implement HashCode fo Long
 */
public class HashcodeLong {

    public int hashcode(long value) {
        return (int) (value ^ (value >>> 32));
    }

}
