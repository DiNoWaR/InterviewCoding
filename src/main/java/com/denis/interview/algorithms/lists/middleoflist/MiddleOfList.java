package com.denis.interview.algorithms.lists.middleoflist;

import com.denis.interview.util.ListNode;

/**
 * Find middle of list with one iteration
 */
public class MiddleOfList {

    public static ListNode<Integer> getMiddleElement(ListNode<Integer> head) {

        ListNode<Integer> fastPointer = head;
        ListNode<Integer> slowPointer = head;

        if (head != null) {
            while (fastPointer != null && fastPointer.hasNext()) {
                fastPointer = fastPointer.getNext().getNext();
                slowPointer = slowPointer.getNext();
            }
        }
        return slowPointer;
    }

    public static void main(String[] args) {

        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> fourth = new ListNode<>(4);
        ListNode<Integer> fifth = new ListNode<>(5);
        ListNode<Integer> sixth = new ListNode<>(6);
        ListNode<Integer> seventh = new ListNode<>(7);
        ListNode<Integer> eights = new ListNode<>(8);
        ListNode<Integer> nineths = new ListNode<>(9);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
        seventh.setNext(eights);
        eights.setNext(nineths);

        System.out.println(getMiddleElement(first).getValue());

    }

}
