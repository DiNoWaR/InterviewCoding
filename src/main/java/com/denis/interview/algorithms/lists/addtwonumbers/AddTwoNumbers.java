package com.denis.interview.algorithms.lists.addtwonumbers;

import com.denis.interview.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {


    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> first, ListNode<Integer> second) {

        long firstResult = getSumOfReversedList(first);
        long secondResult = getSumOfReversedList(second);

        long sum = firstResult + secondResult;

        int mod = (int) (sum % 10);
        sum = sum / 10;

        ListNode<Integer> head = new ListNode(mod);
        ListNode<Integer> current = head;

        while (sum > 0) {
            int value = (int) (sum % 10);
            ListNode<Integer> node = new ListNode<>(value);
            current.setNext(node);
            current = current.getNext();
            sum = sum / 10;
        }

        return head;
    }

    private static int getSumOfReversedList(ListNode<Integer> pointer) {

        int result = 0;

        int pow = 0;

        while (pointer != null) {

            int temp = (int) (pointer.getValue() * Math.pow(10, pow));

            result += temp;
            pow++;
            pointer = pointer.getNext();
        }
        return result;
    }


    public static void main(String[] args) {


        ListNode<Integer> first = new ListNode<>(2);
        ListNode<Integer> second = new ListNode<>(4);
        ListNode<Integer> third = new ListNode<>(3);

        first.setNext(second);
        second.setNext(third);

        ListNode<Integer> fourth = new ListNode<>(5);
        ListNode<Integer> fifth = new ListNode<>(6);
        ListNode<Integer> sixth = new ListNode<>(4);

        fourth.setNext(fifth);
        fifth.setNext(sixth);

        ListNode<Integer> head = addTwoNumbers(first, fourth);

        head.getLineage(head);

    }

}
