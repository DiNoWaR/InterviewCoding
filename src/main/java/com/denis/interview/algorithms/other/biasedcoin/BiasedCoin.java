package com.denis.interview.algorithms.other.biasedcoin;

/**
 * You are given a function foo() that represents a biased coin.
 * When foo() is called, it returns 0 with 60% probability, and 1 with 40% probability.
 * Write a new function that returns 0 and 1 with 50% probability each.
 * Your function should use only foo(), no other library method.
 */
public class BiasedCoin {

    //stub just for compile
    public int foo() {
        return 0;
    }


    public int myFunc() {

        var first = foo();
        var second = foo();

        if (first == 0 && second == 1) {
            return 0;
        }

        if (first == 1 && second == 0) {
            return 1;
        }
        return myFunc();
    }

}
