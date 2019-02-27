package com.denis.interview.datastructures.lruсaсhe;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put. If cache is full,then it should
 * evict least used element and add current element. All operations must have O(1) complexity.
 */
public class LRUCache<K, V> {

    private Map<K, CacheNode<K, V>> map;

    private final int MAX_SIZE;
    private int currentSize;

    private CacheNode<K, V> head;
    private CacheNode<K, V> tail;


    public LRUCache(int maxSize) {
        map = new HashMap<>();
        MAX_SIZE = maxSize;
        currentSize = 0;
    }


    public void put(K key, V value) {

        if (currentSize == MAX_SIZE) {
            evict();
        }

        CacheNode<K, V> node = new CacheNode<>(key, value);
        map.put(node.getKey(), node);

        if (head == null) {
            head = node;
            tail = node;
            currentSize++;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
            currentSize++;
        }
    }

    public V get(K key) {

        if (head != null) {
            CacheNode<K, V> node = deleteNode(map.get(key));
            head.setPrevious(node);
            node.setNext(head);
            head = node;
            return node.getValue();
        }
        return null;
    }


    private void evict() {
        CacheNode<K, V> previous = tail.getPrevious();
        map.remove(tail.getKey());
        previous.setNext(null);
        tail.setPrevious(null);
        tail = previous;
        currentSize--;
    }

    private CacheNode<K, V> deleteNode(CacheNode<K, V> node) {

        if (node == head) {
            return node;
        }

        if (node == tail) {
            CacheNode<K, V> previous = node.getPrevious();
            node.setPrevious(null);
            previous.setNext(null);
            tail = previous;
            return node;
        }

        CacheNode<K, V> next = node.getNext();
        CacheNode<K, V> previous = node.getPrevious();

        node.setNext(null);
        node.setPrevious(null);

        previous.setNext(next);
        next.setPrevious(previous);

        return node;
    }


    public static void main(String[] args) {

        LRUCache<String, Integer> cache = new LRUCache<>(4);

        cache.put("1", 10);
        cache.put("2", 30);
        cache.put("3", 50);
        cache.put("4", 20);

        cache.get("1");
        cache.get("4");

        cache.put("5", 126);

    }
}
