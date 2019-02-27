package com.denis.interview.datastructures.lruсaсhe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CacheNode<K, V> {

    private K key;
    private V value;

    public CacheNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private CacheNode<K, V> next;
    private CacheNode<K, V> previous;

}
