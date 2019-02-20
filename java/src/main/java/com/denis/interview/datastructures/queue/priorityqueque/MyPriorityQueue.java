package com.denis.interview.datastructures.queue.priorityqueque;

import java.util.Comparator;

//
public class MyPriorityQueue<T> {

    private HeapNode<T> root;
    private Comparator<T> comparator;


    public MyPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }


    public T peek() {
        return root.getValue();
    }

    public void add(T item) {

        if (root == null) {
            root = new HeapNode<>(item);
        } else {
            sieveDown(item);
        }
    }


    private void sieveDown(T item) {



    }

    private void swap(HeapNode<T> first, HeapNode<T> second) {

        T temp = second.getValue();
        second.setValue(first.getValue());
        first.setValue(temp);

    }

}
