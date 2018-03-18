package com.denis.interview.algorithms.binarytrees.mindifofvaluesoftwonodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a Binary Search Tree (TreeNode) with the root node root,
 * return the minimum difference between the values of any two different nodes in the tree.
 *
 * First approach : Write to Array
 *
 */
public class FirstApproach {

    private List<Integer> values;

    public int minDiffInBST(TreeNode root) {
        values = new ArrayList();
        depthFirstSearch(root);
        Collections.sort(values);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < values.size() - 1; ++i) {
            ans = Math.min(ans, values.get(i + 1) - values.get(i));
        }
        return ans;
    }

    private void depthFirstSearch(TreeNode node) {

        if (node == null) {
            return;
        }
        values.add(node.getValue());

        depthFirstSearch(node.getLeft());
        depthFirstSearch(node.getRight());
    }

}
