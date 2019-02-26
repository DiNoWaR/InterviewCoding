package com.denis.interview.algorithms.lists.reverselist;

import com.denis.interview.util.ListGenerator;
import com.denis.interview.util.ListNode;

/**
 * Reverse a single linked list with one iteration
 */
class ReverseLinkedList {

    public static ListNode<Integer> reverseWithLoop(ListNode<Integer> head) {

        ListNode<Integer> current = head;
        ListNode<Integer> nextNode = null;
        ListNode<Integer> previous = null;

        while (current != null) {

            // copy a pointer to the next element
            // before we overwrite currentNode.next
            nextNode = current.getNext();

            // reverseWithLoop the 'next' pointer
            current.setNext(previous);

            // step forward in the list
            previous = current;
            current = nextNode;
        }
        return previous;
    }


    public static ListNode<Integer> reverseRecursive(ListNode<Integer> head) {

        if ((head == null) || (head.getNext() == null)) {
            return head;
        }

        ListNode<Integer> reverse = reverseRecursive(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);
        return reverse;
    }


    public static void main(String[] args) {

        var myList = ListGenerator.generateList(1, 4, true);
        myList.printLineage();

        reverseRecursive(myList).printLineage();

    }
}
