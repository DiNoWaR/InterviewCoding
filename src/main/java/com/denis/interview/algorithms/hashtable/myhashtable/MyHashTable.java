package com.denis.interview.algorithms.hashtable.myhashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashTable<K, V> {

    private LinkedList<Entry<K, V>>[] keyArray;
    private double loadFactor = 0.7;
    private int initialCapacity = 16;
    private int size = 0;

    public MyHashTable() {
        keyArray = new LinkedList[initialCapacity];
    }


    public void put(K key, V value) {

        int index = hashFunction(key);
        if (keyArray.length * loadFactor < size) {
            rehash();
        }
        if (keyArray[index] == null) {
            LinkedList<Entry<K, V>> list = new LinkedList<>();
            list.add(new Entry<>(key, value));
            keyArray[index] = list;
            size++;
        } else {
            boolean exist = false;
            for (Entry<K, V> entry : keyArray[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    exist = true;
                }
            }
            if (!exist) {
                keyArray[index].add(new Entry<>(key, value));
            }
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
    public void remove(K key){
        int index = hashFunction(key);
        if(keyArray[index]!=null){
            for(Entry<K,V> entry:keyArray[index]){
                if(entry.key.equals(key)){
                    keyArray[index].remove(entry);
                }
            }
        }
    }

    private int hashFunction(K key) {
        return key.hashCode() % keyArray.length;
    }

    private void rehash() {
        LinkedList<Entry<K, V>>[] newArray = new LinkedList[keyArray.length * 2];

        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null) {
                for (Entry<K, V> entry : keyArray[i]) {
                    int index = hashFunction(entry.key);
                    if (newArray[index] == null) {
                        LinkedList<Entry<K, V>> list = new LinkedList<>();
                        list.add(entry);
                        newArray[index] = list;
                    } else {
                        newArray[index].add(entry);
                    }
                }
            }
        }
        keyArray = newArray;

    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();
        myHashTable.put("bgg", 1);
        myHashTable.put("bgg2", 2);
        myHashTable.put("bgg3", 3);
        myHashTable.put("bgg4", 4);
        myHashTable.put("bgg5", 5);
        myHashTable.put("bgg6", 6);
        myHashTable.put("bgg7", 7);
        myHashTable.put("bgg8", 8);
        myHashTable.put("bgg9", 9);
        myHashTable.put("bgg10", 10);
        myHashTable.remove("bgg4");
        System.out.println(myHashTable.get("bgg"));
        System.out.println(myHashTable.get("bgg2"));
        System.out.println(myHashTable.get("bgg3"));
        System.out.println(myHashTable.get("bgg4"));
        System.out.println(myHashTable.get("bgg5"));
        System.out.println(myHashTable.get("bgg6"));
        System.out.println(myHashTable.get("bgg7"));
        System.out.println(myHashTable.get("bgg8"));
        System.out.println(myHashTable.get("bgg9"));
        System.out.println(myHashTable.get("bgg10"));
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
