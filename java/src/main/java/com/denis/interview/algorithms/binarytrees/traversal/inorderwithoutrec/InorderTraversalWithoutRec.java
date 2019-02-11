package com.denis.interview.algorithms.binarytrees.traversal.inorderwithoutrec;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

import java.util.Stack;

/**
 * Implement inorder traversal of binary search tree without recursion
 */
public class InorderTraversalWithoutRec {


    public static void inorderTraversal(TreeNode<Integer> root) {

        TreeNode<Integer> current = root;
        Stack<TreeNode<Integer>> stack = new Stack<>();

        boolean done = false;

        while (!done) {

            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {

                if (!stack.isEmpty()) {
                    current = stack.pop();
                    System.out.print(current.getValue() + " ");
                    current = current.getRight();
                } else {
                    done = true;
                }
            }
        }
    }


    public static void main(String[] args) {

        var root = BinaryTreeGenerator.generateBinarySearchTree();

        inorderTraversal(root);
    }

}
