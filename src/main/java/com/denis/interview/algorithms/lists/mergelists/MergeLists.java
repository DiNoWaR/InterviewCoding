package com.denis.interview.algorithms.lists.mergelists;

import com.denis.interview.algorithms.sorting.generator.Generator;
import com.denis.interview.util.ListGenerator;
import com.denis.interview.util.ListNode;

/**
 * Given two linked lists sorted in ascending order. Merge them in-place and return head of the merged list.
 * For example, if first list is 10->20->30 and second list is 15->17, then the result list should be
 * 10->15->17->20->30.
 * It is strongly recommended to do merging in-place using O(1) extra space.
 */
public class MergeLists {

    public static ListNode<Integer> merge(ListNode<Integer> first, ListNode<Integer> second) {

        ListNode<Integer> head = null;
        ListNode<Integer> current = null;

        ListNode<Integer> firstPointer = first;
        ListNode<Integer> secondPointer = second;

        head = firstPointer.getValue() <= secondPointer.getValue() ? firstPointer : secondPointer;
        current = head;

        while (current.hasNext()) {

            if (head == firstPointer) {

                if (firstPointer.getNext().getValue() < secondPointer.getValue()) {
                    current.setNext(secondPointer);
                    secondPointer = secondPointer.getNext();
                    current = current.getNext();
                } else {
                    current.setNext(current.getNext());
                    firstPointer = firstPointer.getNext();
                    current = current.getNext();
                }
            } else {

                if (secondPointer.getNext().getValue() < firstPointer.getValue()) {
                    current.setNext(firstPointer);
                    firstPointer = firstPointer.getNext();
                    current = current.getNext();
                } else {
                    current.setNext(current.getNext());
                    secondPointer = secondPointer.getNext();
                    current = current.getNext();
                }

            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode<Integer> first = ListGenerator.generateList(3, 10, true);
        ListNode<Integer> second = ListGenerator.generateList(15, 10, true);

        ListNode<Integer> merged = merge(first, second);
        merged.getLineage(merged);

    }

}
