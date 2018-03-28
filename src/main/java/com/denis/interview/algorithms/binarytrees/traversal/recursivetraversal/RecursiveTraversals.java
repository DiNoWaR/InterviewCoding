package com.denis.interview.algorithms.binarytrees.traversal.recursivetraversal;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

/**
 * Implement all recursive traversals of binary tree: Pre-order Traversal, In-order Traversal, Post-order Traversal
 */
public class RecursiveTraversals {

    public static void preOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public static void inOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }
        System.out.print(root.getValue() + " ");
        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }

    public static void postOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getValue() + " ");
    }


    public static void main(String[] args) {

        TreeNode<Integer> root = BinaryTreeGenerator.generateBinarySearchTree();

        preOrderTraversal(root);
        System.out.println();
        System.out.println("----------------------");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("----------------------");
        postOrderTraversal(root);
    }

}
