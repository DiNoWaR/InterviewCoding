package com.denis.interview.algorithms.interviewcake.binarysearchtreechecker;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

/**
 * Write a method to check that a binary tree ↴ is a valid binary search tree.
 */
public class BinarySearchTreeChecker {

    private boolean valid = true;


    public boolean BSTChecker(TreeNode<Integer> root) {
        validateBST(root);
        return valid;
    }

    private void validateBST(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return;
        }

        if (root.getLeft() != null) {
            if (root.getLeft().getValue() > root.getValue()) {
                valid = false;
            }
        }

        if (root.getRight() != null) {
            if (root.getRight().getValue() < root.getValue()) {
                valid = false;
            }
        }

        validateBST(root.getLeft());
        validateBST(root.getRight());
    }

    public static void main(String[] args) {

        BinarySearchTreeChecker checker = new BinarySearchTreeChecker();
        TreeNode<Integer> tree = BinaryTreeGenerator.generateBinarySearchTree();
        System.out.println(checker.BSTChecker(tree));

    }
}
