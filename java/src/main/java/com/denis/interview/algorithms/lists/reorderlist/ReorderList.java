package com.denis.interview.algorithms.lists.reorderlist;

import com.denis.interview.util.ListGenerator;
import com.denis.interview.util.ListNode;

/**
 * Given a singly linked list L: L0 → L1 → … →Ln-1 → Ln,
 * reorder it to: L0 →Ln →L1 →Ln-1 →L2 →Ln-2 →…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * <p>
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList<T> {


    public ListNode<T> reorderTheList(ListNode<T> head) {

        if (!head.hasNext()) {
            return head;
        }

        var fast = head;
        var slow = head;

        if (head != null) {
            while (fast != null && fast.hasNext()) {
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
        }

        var rightHead = revert(slow.getNext());
        slow.setNext(null);

        ListNode<T> result = new ListNode<>(null);
        ListNode<T> current = result;
        merge(current, head, rightHead, 0);

        return result.getNext();
    }


    private ListNode<T> revert(ListNode<T> head) {

        if ((head == null) || (head.getNext() == null)) {
            return head;
        }

        ListNode<T> reverse = revert(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);
        return reverse;
    }

    private void merge(ListNode<T> current, ListNode<T> left, ListNode<T> right, int counter) {

        if (left == null || right == null) {
            current.setNext(left);
            return;
        }

        if (counter % 2 == 0) {
            ListNode<T> leftTail = left.getNext();
            left.setNext(null);
            current.setNext(left);
            current = current.getNext();
            merge(current, leftTail, right, counter + 1);
        } else {
            ListNode<T> rightTail = right.getNext();
            right.setNext(null);
            current.setNext(right);
            current = current.getNext();
            merge(current, left, rightTail, counter + 1);
        }

    }


    public static void main(String[] args) {

        ListNode<Integer> head = ListGenerator.generateList(1, 10, true);

        ListNode<Integer> result = new ReorderList<Integer>().reorderTheList(head);
        result.printLineage();
    }

}
