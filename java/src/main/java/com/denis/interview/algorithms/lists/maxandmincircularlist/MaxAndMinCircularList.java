package com.denis.interview.algorithms.lists.maxandmincircularlist;

import com.denis.interview.util.ListNode;

/**
 * Given a singly circular linked list of N nodes. The task is to find the smallest and largest elements in the circular linked list.
 * <p>
 * Examples:
 * <p>
 * Input : List = 99->11->22->33->44->55->66
 * Output : Minimum = 11, Maximum = 99
 * <p>
 * Input : List = 12->11->9->33->125->6->99
 * Output : Minimum = 6, Maximum = 125
 */
public class MaxAndMinCircularList<T extends Comparable<T>> {


    public void printMaxAndMin(ListNode<T> head) {

        if (head == null || !head.hasNext()) {
            return;
        }

        T min = head.getValue();
        T max = head.getValue();

        ListNode<T> current = head.getNext();

        while (current != head) {

            if (current.getValue().compareTo(max) > 0) {
                max = current.getValue();
            }

            if (current.getValue().compareTo(min) < 0) {
                min = current.getValue();
            }
            current = current.getNext();
        }

        System.out.println(min);
        System.out.println(max);
    }


    public static void main(String[] args) {

        ListNode<Integer> head = new ListNode<>(5);
        ListNode<Integer> second = new ListNode<>(1);
        ListNode<Integer> third = new ListNode<>(10);
        ListNode<Integer> fourth = new ListNode<>(2);
        ListNode<Integer> fifth = new ListNode<>(4);

        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(head);

        new MaxAndMinCircularList<Integer>().printMaxAndMin(head);

    }

}
