package com.denis.interview.algorithms.binarytrees.rootleafpathssum;

import com.denis.interview.util.TreeNode;

/**
 * Given a binary tree, where every node value is a number.
 * Find the sum of all the numbers which are formed from root to leaf paths.
 * <p>
 * For example consider the following Binary Tree.
 * <p>
 *      6
 *    /  \
 *   3    5
 *  / \    \
 * 2   5    4
 *   /  \
 *  7    4
 *
 * <p>
 * There are 4 leaves, hence 4 root to leaf paths:
 * Path                      Number
 * 6->3->2                   600+30+2=632
 * 6->3->5->7                6000+300+50+7=6357
 * 6->3->5->4                6000+300+50+4=6354
 * 6->5->4                   600+50+4=654
 * <p>
 * Answer = 632 + 6357 + 6354 + 654 = 13997
 */
public class RootToLeafPathsSum {


    private static int treePathSumUtil(TreeNode<Integer> root, int value) {

        //Base case
        if (root == null) {
            return 0;
        }

        int newValue = value * 10 + root.getValue();

        if (root.getLeft() == null && root.getRight() == null) {
            return newValue;
        }

        return treePathSumUtil(root.getLeft(), newValue) + treePathSumUtil(root.getRight(), newValue);

    }


    public static int treePathSum(TreeNode<Integer> root) {
        return treePathSumUtil(root, 0);
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(6);

        root.setLeft(new TreeNode<>(3));
        root.setRight(new TreeNode<>(5));

        root.getLeft().setLeft(new TreeNode<>(2));
        root.getLeft().setRight(new TreeNode<>(5));

        root.getLeft().getRight().setRight(new TreeNode<>(4));
        root.getLeft().getRight().setLeft(new TreeNode<>(7));

        root.getRight().setRight(new TreeNode<>(4));

        System.out.println(treePathSum(root));

    }

}
