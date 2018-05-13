package com.denis.interview.algorithms.hashtable.myhashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashTable<K, V> {

    private LinkedList<Entry<K, V>>[] keyArray;
    private double loadFactor = 0.7;
    private int initialCapacity = 16;

    public MyHashTable() {
        keyArray = new LinkedList[initialCapacity];
    }


    public void put(K key, V value) {

        int index = hashFunction(key);

        if (keyArray[index] == null) {
            LinkedList<Entry<K, V>> list = new LinkedList<>();
            list.add(new Entry<>(key, value));
            keyArray[index] = list;
        } else {
            keyArray[index].add(new Entry<>(key, value));
        }
    }

    public V get(K key) {

        int index = hashFunction(key);

        if (keyArray[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : keyArray[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    private int hashFunction(K key) {
        return key.hashCode() % keyArray.length;
    }

    private void rehash() {
        List<Entry<K, V>>[] newArray = new List[keyArray.length * 2];

        for (int i = 0; i < keyArray.length; i++) {
            int newIndex = hashFunction(keyArray[i].getFirst().key);

        }

    }

    public static void main(String[] args) {

    }

    static class Entry<K, V> {

        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

}
