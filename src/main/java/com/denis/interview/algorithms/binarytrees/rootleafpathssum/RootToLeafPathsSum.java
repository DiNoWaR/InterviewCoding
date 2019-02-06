package com.denis.interview.algorithms.binarytrees.rootleafpathssum;

import com.denis.interview.util.TreeNode;

import java.util.*;

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


    private static List<Stack<Integer>> stacks = new ArrayList<>();


    public static void traverseTree(TreeNode<Integer> root, LinkedList<Integer> list) {

        if (root == null) {
            return;
        }

        if (root.getRight() == null && root.getLeft() == null) {
            list.add(root.getValue());
            Stack<Integer> result = new Stack<>();

            for (Integer item : list) {
                result.push(item);
            }
            stacks.add(result);
            list.removeLast();
        } else {

            list.add(root.getValue());

            traverseTree(root.getLeft(), list);
            traverseTree(root.getRight(), list);
        }
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

        traverseTree(root, new LinkedList<>());


    }

}
