package com.denis.interview.datastructures.queue.priorityqueque;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeapNode<T> {

    private T value;


    public HeapNode(T value) {
        this.value = value;
        parent = this;
    }


    private HeapNode<T> parent;
    private HeapNode<T> left;
    private HeapNode<T> right;

}
