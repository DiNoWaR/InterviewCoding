package com.denis.interview.algorithms.lists.reverselist;

import com.denis.interview.util.ListNode;

/**
 * Reverse a single linked list with one iteration
 */
class ReverseLinkedList {

    public static ListNode<Integer> reverse(ListNode<Integer> head) {

        ListNode<Integer> prev = null;
        ListNode<Integer> next = null;

        ListNode<Integer> current = head;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;

        return head;
    }

    public static void main(String[] args) {

        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> fourth = new ListNode<>(4);
        ListNode<Integer> fifth = new ListNode<>(5);
        ListNode<Integer> sixth = new ListNode<>(6);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);

        first.getLineage(first);

    }
}
