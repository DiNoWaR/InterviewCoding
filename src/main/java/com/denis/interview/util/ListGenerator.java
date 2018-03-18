package com.denis.interview.util;

/**
 * Util class to generate sample linked list
 */
public class ListGenerator {

    public static ListNode generateList() {

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

        return first;
    }

}
