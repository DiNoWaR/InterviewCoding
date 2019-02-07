package com.denis.interview.algorithms.binarytrees.identicaltrees;

import com.denis.interview.util.BinaryTreeGenerator;
import com.denis.interview.util.TreeNode;

import java.util.LinkedList;

/**
 * Implement function to check if two binary trees are identical (Iterative)
 */
public class IdenticalTrees {


    public static boolean treesIdentical(TreeNode<Integer> first, TreeNode<Integer> second) {

        if (first == null || second == null) {
            return false;
        }

        LinkedList<TreeNode<Integer>> firstQueue = new LinkedList<>();
        LinkedList<TreeNode<Integer>> secondQueue = new LinkedList<>();

        firstQueue.add(first);
        secondQueue.add(second);

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {

            TreeNode<Integer> firstCurrent = firstQueue.poll();
            TreeNode<Integer> secondCurrent = secondQueue.poll();

            if (!firstCurrent.getValue().equals(secondCurrent.getValue())) {
                return false;
            }

            if (firstCurrent.getLeft() != null) {
                firstQueue.add(firstCurrent.getLeft());
            }

            if (firstCurrent.getRight() != null) {
                firstQueue.add(firstCurrent.getRight());
            }

            if (secondCurrent.getLeft() != null) {
                secondQueue.add(secondCurrent.getLeft());
            }

            if (secondCurrent.getRight() != null) {
                secondQueue.add(secondCurrent.getRight());
            }

        }
        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }

    public static void main(String[] args) {

        var rootOne = BinaryTreeGenerator.generateBinarySearchTree();
        var rootTwo = BinaryTreeGenerator.generateBinarySearchTree();

        System.out.println(treesIdentical(rootOne, rootTwo));

    }

}
