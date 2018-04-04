package com.denis.interview.algorithms.lists.reverselist;

import com.denis.interview.util.ListGenerator;
import com.denis.interview.util.ListNode;

/**
 * Reverse a single linked list with one iteration
 */
class ReverseLinkedList {

    public static ListNode<Integer> reverse(ListNode<Integer> head) {

        ListNode<Integer> current = head;
        ListNode<Integer> previous = null;
        ListNode<Integer> prePrevious = null;

        while (current.hasNext()) {
            prePrevious = previous;
            previous = current;
            current = current.getNext();
            previous.setNext(prePrevious);
        }

        current.setNext(previous);
        return current;
    }

    public static void main(String[] args) {

        var myList = ListGenerator.generateList(1, 16, true);
        myList.getLineage(myList);

        ListNode<Integer> newHead = reverse(myList);
        myList.getLineage(newHead);
    }
}
