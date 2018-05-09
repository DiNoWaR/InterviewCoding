package com.denis.interview.algorithms.interviewcake.balancedbinarytree;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

public class BalancedBinaryTree {

    private static int depth = 0;

    public static void preOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public static void main(String[] args) {

        TreeNode<Integer> tree = BinaryTreeGenerator.generateBinarySearchTree();
        preOrderTraversal(tree);
    }
}
