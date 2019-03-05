package com.denis.interview.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Util class for linked list tasks
 */
@Getter
@Setter
public class ListNode<T> {

    private T value;

    private ListNode<T> next;
    private ListNode<T> previous;


    public ListNode(T value) {
        this.value = value;
    }

    public ListNode() {
    }


    public void printLineage() {

        ListNode<T> pointer = this;

        while (pointer != null) {
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }

    public void printLineageOfCircularList() {

        ListNode<T> slow = null;
        ListNode<T> fast = null;

        if (this != null) {

            if (!this.hasNext()) {
                System.out.println(this.value);
                return;
            }

            slow = this;
            fast = slow.next;

            while (fast != slow && fast != null && fast.hasNext()) {
                System.out.print(slow.value + " ");
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
            System.out.print(slow.value);
        }
    }

    public boolean hasNext() {
        return next != null;
    }
}
