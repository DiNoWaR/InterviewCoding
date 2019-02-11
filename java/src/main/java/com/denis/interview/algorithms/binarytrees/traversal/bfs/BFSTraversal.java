package com.denis.interview.algorithms.binarytrees.traversal.bfs;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

import java.util.LinkedList;

/**
 * Implement bfs traversal (Level order traversal) of binary tree
 */
public class BFSTraversal {


    public static void bfsTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode<Integer> current = queue.poll();
            System.out.print(current.getValue() + " ");

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
        }
    }

    public static void main(String[] args) {

        var root = BinaryTreeGenerator.generateBinarySearchTree();

        bfsTraversal(root);
        System.out.println();
        System.out.println("----------------------");

    }

}
