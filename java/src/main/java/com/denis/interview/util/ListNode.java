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


    public ListNode(T value) {
        this.value = value;
    }

    public ListNode() {

    }

    public void getLineage(ListNode<T> head) {

        ListNode<T> pointer = head;

        while (pointer != null) {
            System.out.print(pointer.getValue() + " ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }

    public boolean hasNext() {
        return next != null;
    }
}
