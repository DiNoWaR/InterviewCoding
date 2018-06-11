package com.denis.interview.algorithms.lrucashe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node {

    private String key;
    private Integer value;

    public Node(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    private Node next;
    private Node previous;

}
