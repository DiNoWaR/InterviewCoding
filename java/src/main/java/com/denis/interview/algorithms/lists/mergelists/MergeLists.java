package com.denis.interview.algorithms.lists.mergelists;

import com.denis.interview.util.ListGenerator;
import com.denis.interview.util.ListNode;

/**
 * Given two linked lists sorted in ascending order. Merge them in-place and return head of the merged list.
 * For example, if first list is 10->20->30 and second list is 15->17, then the result list should be
 * 10->15->17->20->30.
 * It is strongly recommended to do merging in-place using O(1) extra space.
 */
public class MergeLists {


    public static ListNode<Integer> mergeRecursively(ListNode<Integer> first, ListNode<Integer> second) {

        if (first == null) return second;
        if (second == null) return first;

        if (first.getValue() < second.getValue()) {
            first.setNext(mergeRecursively(first.getNext(), second));
            return first;
        } else {
            second.setNext(mergeRecursively(second.getNext(), first));
            return second;
        }
    }

    public static void main(String[] args) {

        ListNode<Integer> first = ListGenerator.generateList(3, 10, true);
        ListNode<Integer> second = ListGenerator.generateList(5, 15, true);
        second.printLineage();
        first.printLineage();
        ListNode<Integer> merged = mergeRecursively(first, second);
        merged.printLineage();

    }

}
