package com.denis.interview.util;

import java.util.Random;

/**
 * Util class to generate sample linked list
 */
public class ListGenerator {

    public static ListNode generateList(int from, int lenght, boolean sorted) {

        Random random = null;

        int firstNumber = 1;

        if (!sorted) {
            random = new Random();
            firstNumber = random.nextInt(1000) + from;
        }

        ListNode<Integer> first = new ListNode<>(firstNumber);
        ListNode<Integer> current = first;

        for (int i = from + 1; i <= lenght; i++) {

            int number = 0;

            if (sorted) {
                number = i;
            } else {
                number = random.nextInt(1000) + from;
            }

            ListNode<Integer> newNode = new ListNode<>(number);
            current.setNext(newNode);
            current = newNode;
        }
        return first;
    }

}
