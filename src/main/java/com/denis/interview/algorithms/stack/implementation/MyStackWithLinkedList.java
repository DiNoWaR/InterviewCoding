package com.denis.interview.algorithms.stack.implementation;

import com.denis.interview.util.ListNode;

public class MyStackWithLinkedList<T> {

    private ListNode<T> head;


    public void push(T item) {

        if (item != null) {
            ListNode<T> node = new ListNode<>(item);
            node.setNext(head);
            head = node;
        }
    }

    public T pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = head.getValue();
        head = head.getNext();
        return value;
    }

    public T peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }


    public static void main(String[] args) {

        MyStackWithLinkedList<Integer> stack = new MyStackWithLinkedList<>();

        stack.push(4);
        stack.push(6);
        stack.push(12);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

}
