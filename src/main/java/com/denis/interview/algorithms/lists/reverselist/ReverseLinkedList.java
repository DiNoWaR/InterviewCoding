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

        ListNode<Integer> head = new ListNode<>(1);
        head.setNext(new ListNode<>(2));
        head.getNext().setNext(new ListNode<>(3));

        head.getLineage(head);

    }
}
