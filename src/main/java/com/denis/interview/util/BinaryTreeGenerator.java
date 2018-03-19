package com.denis.interview.util;

/**
 * Util class to generate sample binary trees
 */
public class BinaryTreeGenerator {

    public static TreeNode generateBinarySearchTree() {

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

        return root;
    }

}
