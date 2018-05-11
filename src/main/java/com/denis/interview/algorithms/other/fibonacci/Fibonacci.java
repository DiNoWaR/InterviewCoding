package com.denis.interview.algorithms.other.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement sum of fibonacci sequence.
 */
public class Fibonacci {

    public long countFibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        return countFibonacci(n - 1) + countFibonacci(n - 2);
    }

    public long countFibonacciWithMemoization(int n, Map<Integer, Long> map) {

        if (n == 1 || n == 2) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        var fibForN = countFibonacciWithMemoization(n - 1, map) + countFibonacciWithMemoization(n - 2, map);
        map.put(n, fibForN);

        return fibForN;
    }

    public long countFibonacciWithLoop(int n) {

        var result = 0L;

        if (n == 1 || n == 2) {
            return 1;
        }

        var first = 1L;
        var second = 1L;

        for (var i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }


    public static void main(String[] args) {

        var size = 48;

        var values = new HashMap<Integer, Long>();

        var fibonacci = new Fibonacci();

        var start = System.currentTimeMillis();
        System.out.println(fibonacci.countFibonacci(size));
        var end = System.currentTimeMillis();
        System.out.println("Time is:" + (end - start) + " ms");

        System.out.println("-----------------------------------------------------------------------------------------");

        start = System.currentTimeMillis();
        System.out.println(fibonacci.countFibonacciWithMemoization(size, values));
        end = System.currentTimeMillis();
        System.out.println("Time is:" + (end - start) + " ms");

        System.out.println("-----------------------------------------------------------------------------------------");

        start = System.currentTimeMillis();
        System.out.println(fibonacci.countFibonacciWithLoop(size));
        end = System.currentTimeMillis();
        System.out.println("Time is:" + (end - start) + " ms");

    }
}
