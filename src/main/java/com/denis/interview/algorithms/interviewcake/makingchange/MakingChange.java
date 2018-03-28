package com.denis.interview.algorithms.interviewcake.makingchange;

/**
 * Your quirky boss collects rare, old coins...
 *
 * They found out you're a programmer and asked you to solve something they've been wondering for a long time.
 *
 * Write a method that, given:
 *
 * an amount of money
 * an array of coin denominations
 * computes the number of ways to make the amount of money with coins of the available denominations.
 *
 * Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), your program would output 44—the number of ways to make 44¢ with those denominations:
 *
 * 1¢, 1¢, 1¢, 1¢
 * 1¢, 1¢, 2¢
 * 1¢, 3¢
 * 2¢, 2¢
 */
public class MakingChange {

    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }

    public static void main(String[] args) {

        System.out.println(changePossibilitiesBottomUp(3, new int[]{1, 2}));

    }

}
