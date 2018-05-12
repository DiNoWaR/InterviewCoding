package com.denis.interview.algorithms.interviewcake.binarysearchtreechecker;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to check that a binary tree ↴ is a valid binary search tree.
 */
public class BinarySearchTreeChecker {

    private List<Integer> array = new ArrayList<>();


    public boolean BSTChecker(TreeNode<Integer> root) {
        inOrderTraversal(root);

        for (int i = 0; i < array.size() - 1; i++) {

            if (array.get(i) > array.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    private void inOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }
        array.add(root.getValue());
        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    public static void main(String[] args) {

        BinarySearchTreeChecker checker = new BinarySearchTreeChecker();
        TreeNode<Integer> tree = BinaryTreeGenerator.generateBinarySearchTree();
        System.out.println(checker.BSTChecker(tree));

    }
}
