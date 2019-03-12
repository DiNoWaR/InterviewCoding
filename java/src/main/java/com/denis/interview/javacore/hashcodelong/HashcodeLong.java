package com.denis.interview.javacore.hashcodelong;

/**
 * Implement HashCode fo Long
 */
public class HashcodeLong {

    public int hashCode(long value) {
        return (int) (value ^ (value >>> 32));
    }

}
