package com.denis.interview.algorithms.reverselist;

/**
 * Reverse a single linked list with one iteration
 */
class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node) {

        Node prev = null;
        Node next = null;

        Node current = node;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        node = prev;

        return node;
    }

}
