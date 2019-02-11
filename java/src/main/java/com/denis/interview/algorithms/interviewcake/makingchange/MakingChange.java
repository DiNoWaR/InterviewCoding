package com.denis.interview.algorithms.interviewcake.makingchange;

/**
 * Your quirky boss collects rare, old coins...
 * <p>
 * They found out you're a programmer and asked you to solve something they've been wondering for a long time.
 * <p>
 * Write a method that, given:
 * <p>
 * an amount of money
 * an array of coin denominations
 * computes the number of ways to make the amount of money with coins of the available denominations.
 * <p>
 * Example: for amount=4 (4¢) and denominations=[1,2,3](1¢, 2¢ and 3¢), your program would output 4—the number of ways to make 4¢ with those denominations:
 * <p>
 * 1¢, 1¢, 1¢, 1¢
 * 1¢, 1¢, 2¢
 * 1¢, 3¢
 * 2¢, 2¢
 */
public class MakingChange {

    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {

        var waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount

        waysOfDoingNCents[0] = 1;

        for (var coin : denominations) {
            for (var higherAmount = coin; higherAmount <= amount; higherAmount++) {
                var higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }
        return waysOfDoingNCents[amount];
    }

    public static void main(String[] args) {
        System.out.println(changePossibilitiesBottomUp(10, new int[]{1, 2, 3}));
    }

}
