package com.denis.interview.util;

/**
 * Util class to generate sample binary trees
 */
public class BinaryTreeGenerator {

    public static TreeNode generateBinarySearchTree() {

        var root = new TreeNode<>(8);

        var first = new TreeNode<>(3);
        var second = new TreeNode<>(10);
        var third = new TreeNode<>(1);
        var fourth = new TreeNode<>(6);
        var fifth = new TreeNode<>(4);
        var sixth = new TreeNode<>(7);
        var seventh = new TreeNode<>(13);
        var eights = new TreeNode<>(14);

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
