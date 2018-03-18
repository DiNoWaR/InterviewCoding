package com.denis.interview.algorithms.binarytrees.traversal.morristraversal;

import com.denis.interview.util.TreeNode;

/**
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 * The idea of Morris Traversal is based on Threaded Binary Tree.
 * In this traversal, we first create links to InOrder successor and print the data using these links,
 * and finally revert the changes to restore original tree.
 */
class MorrisTraversal {

    /**
     * Function to traverse binary tree without recursion and
     * without stack
     */
    public static void morrisTraversal(TreeNode root) {

        TreeNode<Integer> current, predecessor;

        if (root == null)
            return;

        current = root;

        while (current != null) {

            if (current.getLeft() == null) {
                System.out.print(current.getValue() + " ");
                current = current.getRight();
            } else {
                /* Find the inorder predecessor of current */
                predecessor = current.getLeft();

                while (predecessor.getRight() != null && predecessor.getRight() != current) {
                    predecessor = predecessor.getRight();

                }

                /* Make current as right child of its inorder predecessor */
                if (predecessor.getRight() == null) {
                    predecessor.setRight(current);
                    current = current.getLeft();
                }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else {
                    predecessor.setRight(null);
                    System.out.print(current.getValue() + " ");
                    current = current.getRight();
                }   /* End of if condition predecessor->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }

    public static void main(String args[]) {

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


        morrisTraversal(root);
    }
}
