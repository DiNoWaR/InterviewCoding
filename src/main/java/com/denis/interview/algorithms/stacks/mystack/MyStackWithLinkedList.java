package com.denis.interview.algorithms.stacks.mystack;

import com.denis.interview.util.ListNode;

import java.util.Stack;

/**
 * Implement Stack with standard operations(push, pop, peek, isEmpty) and with O(1) runtime
 */
public class MyStackWithLinkedList {

    private ListNode<Integer> head;
    private Stack<Integer> minStack;


    public MyStackWithLinkedList() {
        minStack = new Stack<>();
    }


    public void push(Integer item) {

        if (item != null) {
            ListNode<Integer> node = new ListNode<>(item);

            if (minStack.isEmpty()) {
                minStack.push(item);
            } else {

                if (item <= minStack.peek()) {
                    minStack.push(item);
                }
            }

            node.setNext(head);
            head = node;
        }
    }

    public Integer pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (peek().equals(minStack.peek())) {
            minStack.pop();
        }

        Integer value = head.getValue();
        head = head.getNext();
        return value;
    }

    public Integer peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }


    public static void main(String[] args) {

        MyStackWithLinkedList stack = new MyStackWithLinkedList();

        stack.push(4);
        stack.push(6);
        stack.push(12);
        stack.push(42);
        stack.push(1);
        stack.push(1);
        stack.push(4);
        stack.push(4);

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("-----------------");
        System.out.println(stack.getMin());

    }

}
