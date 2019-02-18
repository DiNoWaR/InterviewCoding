package com.denis.interview.algorithms.сaсhe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CacheNode {

    private String key;
    private Integer value;

    public CacheNode(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    private CacheNode next;
    private CacheNode previous;

}
