package com.denis.interview.algorithms.binarytrees.traversal.recursivetraversal;

import com.denis.interview.util.TreeNode;

/**
 * Implement all resursive traversals of binary tree: Pre-order Traversal, In-order Traversal, Post-order Traversal
 */
public class RecursiveTraversal {

    public static void inOrderTraversal(TreeNode<Integer> root) {
        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }
        System.out.print(root.getValue() + " ");
        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(8);

        TreeNode<Integer> first = new TreeNode<>(3);
        TreeNode<Integer> second = new TreeNode<>(10);
        TreeNode<Integer> third = new TreeNode<>(1);
        TreeNode<Integer> fourth = new TreeNode<>(6);
        TreeNode<Integer> fifth = new TreeNode<>(4);
        TreeNode<Integer> sixth = new TreeNode<>(7);
        TreeNode<Integer> seventh = new TreeNode<>(13);
        TreeNode<Integer> eights = new TreeNode<>(14);

        root.setLeft(first);
        root.setRight(second);
        first.setLeft(third);
        first.setRight(fourth);
        fourth.setLeft(fifth);
        fourth.setRight(sixth);
        second.setRight(eights);
        eights.setLeft(seventh);

        inOrderTraversal(root);
    }

}
