package com.denis.interview.datastructures.queue.queueviastacks;

import com.denis.interview.datastructures.stack.stackwithlinkedlist.MyStackWithLinkedList;

/**
 * Implement Queue using 2 stacks.
 */
public class QueueViaStacks {

    private MyStackWithLinkedList buffer;
    private MyStackWithLinkedList result;


    public QueueViaStacks() {
        buffer = new MyStackWithLinkedList();
        result = new MyStackWithLinkedList();
    }

    public void add(Integer item) {
        move(result, buffer);
        buffer.push(item);
        move(buffer, result);
    }

    public Integer peek() {
        return result.peek();
    }

    public void remove() {
        result.pop();
    }

    public boolean isEmpty() {
        return result.isEmpty();
    }

    private void move(MyStackWithLinkedList src, MyStackWithLinkedList dest) {
        while (!src.isEmpty()) {
            dest.push(src.pop());
        }
    }


    public static void main(String[] args) {

        QueueViaStacks queue = new QueueViaStacks();

        queue.add(5);
        queue.add(3);
        queue.add(12);

        queue.remove();
        queue.remove();

        queue.add(16);

        System.out.println(queue.peek());
    }
}
