package com.denis.interview.algorithms.binarytrees.treetolist;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.ListNode;
import com.denis.interview.util.TreeNode;

/**
 * Convert a binary tree to a doubly linked circular linked list.(Tree is binary and not BST)
 */
public class ConvertTreeToList<T> {

    ListNode<T> head = null;
    ListNode<T> tail = null;


    public ListNode<T> convertTreeToList(TreeNode<T> root) {

        convertTreeToListRecursive(root, new ListNode<>());

        if (tail != null) {
            tail.setNext(head);
            head.setPrevious(tail);
        }

        return head;
    }

    private void convertTreeToListRecursive(TreeNode<T> root, ListNode<T> current) {

        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            convertTreeToListRecursive(root.getLeft(), new ListNode<>());
        }

        if (head == null) {
            current.setValue(root.getValue());
            head = current;
            tail = head;
        } else if (head != null) {
            current.setValue(root.getValue());
            current.setPrevious(tail);
            tail.setNext(current);
            tail = tail.getNext();
        }

        if (root.getRight() != null) {
            convertTreeToListRecursive(root.getRight(), new ListNode<>());
        }
    }


    public static void main(String[] args) {

        var treeNode = BinaryTreeGenerator.generateBinarySearchTree();
        var converter = new ConvertTreeToList<Integer>();

        ListNode<Integer> listNode = converter.convertTreeToList(treeNode);
        listNode.printLineageOfCircularList();

    }

}
