package com.denis.interview.algorithms.queues.queueviastacks;

import com.denis.interview.algorithms.stacks.implementation.MyStackWithLinkedList;

/**
 * Implement Queue using 2 stacks.
 *
 * @param <T> is a type of data in Queue
 */
public class QueueViaStacks<T> {

    private MyStackWithLinkedList<T> buffer;
    private MyStackWithLinkedList<T> result;

    public QueueViaStacks() {
        buffer = new MyStackWithLinkedList<>();
        result = new MyStackWithLinkedList<>();
    }

    public void add(T item) {
        copy(result, buffer);
        buffer.push(item);
        copy(buffer, result);
    }

    public T peek() {
        return result.peek();
    }

    public void remove() {
        result.pop();
    }

    public boolean isEmpty() {
        return result.isEmpty();
    }

    private void copy(MyStackWithLinkedList<T> src, MyStackWithLinkedList<T> dest) {
        while (!src.isEmpty()) {
            dest.push(src.pop());
        }
    }


    public static void main(String[] args) {

        QueueViaStacks<Integer> queue = new QueueViaStacks<>();

        queue.add(5);
        queue.add(3);
        queue.add(12);

        queue.remove();
        queue.remove();

        queue.add(16);

        System.out.println(queue.peek());
    }
}
