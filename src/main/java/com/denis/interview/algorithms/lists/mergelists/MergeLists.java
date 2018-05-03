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

    public static ListNode<Integer> merge(ListNode<Integer> first, ListNode<Integer> second) {

        ListNode<Integer> firstPointer = first;
        ListNode<Integer> secondPointer = second;

        ListNode<Integer> head = firstPointer.getValue() <= secondPointer.getValue() ? firstPointer : secondPointer;
        ListNode<Integer> firstPointerConstant = firstPointer;
        ListNode<Integer> current = head;
        boolean fbool = false;
        boolean sbool = false;
        ListNode<Integer> firstNext = firstPointer.getNext();
        ListNode<Integer> secondNext = secondPointer.getNext();
        if (head == firstPointerConstant) {
            firstPointer = firstPointer.getNext();
            fbool = true;
        } else {
            secondPointer = secondPointer.getNext();
            sbool = true;
        }

        while (true) {
            if (head == firstPointerConstant) {
                if (firstPointer == null) {
                    current.setNext(secondPointer);
                    break;
                }
                if (secondPointer == null) {
                    current.setNext(firstPointer);
                    break;
                }
                if (firstPointer.getValue() > secondPointer.getValue()) {
                    if (fbool) {
                        firstNext = firstPointer.getNext();
                    }
                    current.setNext(secondPointer);
                    secondPointer = secondNext;
                    if (secondPointer != null) {
                        secondNext = secondPointer.getNext();
                    }
                    current = current.getNext();
                    fbool = false;
                    sbool = true;
                } else {
                    if (sbool) {
                        secondNext = secondPointer.getNext();
                    }
                    current.setNext(firstPointer);
                    firstPointer = firstNext;
                    if (firstPointer != null) {
                        firstNext = firstPointer.getNext();
                    }
                    current = current.getNext();
                    fbool = true;
                    sbool = false;
                }
            } else {
                if (firstPointer == null) {
                    current.setNext(secondPointer);
                    break;
                }
                if (secondPointer == null) {
                    current.setNext(firstPointer);
                    break;
                }

                if (secondPointer.getValue() > firstPointer.getValue()) {
                    if (sbool) {
                        secondNext = secondPointer.getNext();
                    }
                    current.setNext(firstPointer);
                    firstPointer = firstNext;
                    if (firstPointer != null) {
                        firstNext = firstPointer.getNext();
                    }
                    current = current.getNext();
                    sbool = false;
                    fbool = true;
                } else {
                    if (fbool) {
                        firstNext = firstPointer.getNext();
                    }
                    current.setNext(secondPointer);
                    secondPointer = secondNext;
                    if (secondPointer != null) {
                        secondNext = secondPointer.getNext();
                    }
                    sbool = true;
                    fbool = false;
                    current = current.getNext();
                }

            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode<Integer> first = ListGenerator.generateList(3, 10, true);
        ListNode<Integer> second = ListGenerator.generateList(5, 15, true);
        second.getLineage(second);
        first.getLineage(first);
        ListNode<Integer> merged = merge(first, second);
        merged.getLineage(merged);

    }

}
