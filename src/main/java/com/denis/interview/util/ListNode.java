package com.denis.interview.util;

/**
 *
 * Util class for linked list tasks
 */
public class ListNode<T> {

    private T value;

    private ListNode<T> next;
    private boolean hasNext;

    public ListNode(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        if (next == null) {
            return false;
        }
        return true;
    }
}
