package com.denis.interview.util;

/**
 * Util class to generate sample linked list
 */
public class ListGenerator {

    public static ListNode generateList(int from, int to) {

        ListNode<Integer> first = new ListNode<>(from);
        ListNode<Integer> current = first;

        for (int i = from + 1; i <= to; i++) {
            ListNode<Integer> newNode = new ListNode<>(i);
            current.setNext(newNode);
            current = newNode;
        }

        return first;
    }

}
