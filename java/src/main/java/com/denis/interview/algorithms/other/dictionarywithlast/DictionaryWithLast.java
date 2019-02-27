package com.denis.interview.algorithms.other.dictionarywithlast;

import com.denis.interview.util.ListNode;

import java.util.HashMap;

/**
 * Write a new data structure, "Dictionary with Last"
 * <p>
 * Methods:
 * set(key, value) - adds an element to the dictionary
 * get(key) - returns the element
 * delete(key) - removes the element
 * last() - returns the last key that was added or read.
 * <p>
 * In case a key was removed, last will return the previous key in order.
 */
public class DictionaryWithLast<K, V> {

    private HashMap<K, ListNode<V>> map;

    private ListNode<V> head;
    private ListNode<V> tail;


    public DictionaryWithLast() {
        map = new HashMap<>();
    }


    public void set(K key, V value) {

        if (head != null) {
            ListNode<V> last = new ListNode<>(value);
            tail.setNext(last);
            last.setPrevious(tail);
            tail = tail.getNext();
            map.put(key, last);
        } else {
            head = new ListNode<>(value);
            tail = head;
            map.put(key, head);
        }
    }

    public V get(K key) {

        if (map.containsKey(key)) {
            ListNode<V> node = map.get(key);
            moveNodeToTail(node);
            return node.getValue();
        } else return null;
    }

    public void delete(K key) {

        ListNode<V> node = map.get(key);

        if (tail != node) {

            if (head != node) {
                ListNode<V> next = node.getNext();
                ListNode<V> previous = node.getPrevious();

                node.setNext(null);
                node.setPrevious(null);

                previous.setNext(next);
                next.setPrevious(previous);
                map.remove(key);
            } else {
                ListNode<V> next = node.getNext();
                head = next;
                node.setNext(null);
                map.remove(key);
            }
        } else {
            ListNode<V> previous = tail.getPrevious();
            previous.setNext(null);
            tail.setPrevious(null);
            tail = previous;
            map.remove(key);
        }

    }

    public V last() {
        return tail.getValue();
    }


    private void moveNodeToTail(ListNode<V> node) {

        if (tail != node) {

            if (head != node) {
                ListNode<V> next = node.getNext();
                ListNode<V> previous = node.getPrevious();

                node.setNext(null);
                node.setPrevious(null);

                previous.setNext(next);
                next.setPrevious(previous);
                tail.setNext(node);
                node.setPrevious(tail);
                tail = tail.getNext();
            } else {
                ListNode<V> next = node.getNext();
                head = next;
                node.setNext(null);
                tail.setNext(node);
                node.setPrevious(tail);
                tail = tail.getNext();
            }
        }


    }


    public static void main(String[] args) {

        var dictionary = new DictionaryWithLast<String, Integer>();

        dictionary.set("Denis", 1);
        dictionary.set("Bug", 4);
        dictionary.set("Gosty", 3);
        dictionary.set("Linki", 10);
        dictionary.set("Anatoly", 15);

        dictionary.get("Bug");
        System.out.println(dictionary.last());

        dictionary.delete("Bug");
        System.out.println(dictionary.last());

        dictionary.set("Bug", 4);
        System.out.println(dictionary.last());

    }

}
