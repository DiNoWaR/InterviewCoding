package com.denis.interview.algorithms.binarytrees.mergebinarytrees;

import com.denis.interview.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MergeBST {

    private List<Integer> integers = new ArrayList<>();
    private TreeNode<Integer> head = new TreeNode<>(null);


    public TreeNode<Integer> mergeTrees(TreeNode<Integer> first, TreeNode<Integer> second) {

        inOrderTraversal(first);
        Integer[] firstArray = integers.toArray(new Integer[integers.size()]);
        integers.clear();

        inOrderTraversal(second);
        Integer[] secondArray = integers.toArray(new Integer[integers.size()]);
        integers.clear();

        Integer[] mergedArray = deleteDuplicatesFromArray(merge(firstArray, secondArray));

        createBSTFromSortedArray(mergedArray, head);

        return head;
    }


    private static void createBSTFromSortedArray(Integer[] array, TreeNode<Integer> root) {

        if (array.length == 1) {
            if (array[0] > root.getValue()) {
                root.setRight(new TreeNode<>(array[0]));
            } else {
                root.setLeft(new TreeNode<>(array[0]));
            }
        }

        int n = array.length / 2;

        root.setValue(array[n]);
        root.setRight(new TreeNode<>(null));
        root.setLeft(new TreeNode<>(null));


        Integer[] left = null;
        Integer[] right = null;

        if (array.length % 2 == 0) {

            left = new Integer[n];
            right = new Integer[n];

            System.arraycopy(array, 0, left, 0, n);
            System.arraycopy(array, n, right, 0, n);

        } else if (array.length % 2 != 0) {

            left = new Integer[n];
            right = new Integer[n + 1];

            System.arraycopy(array, 0, left, 0, n);
            System.arraycopy(array, n, right, 0, n + 1);
        }

        createBSTFromSortedArray(left, root.getLeft());
        createBSTFromSortedArray(right, root.getRight());
    }

    private void inOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }

        integers.add(root.getValue());

        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }

    }

    private Integer[] merge(Integer[] first, Integer[] second) {

        var answer = new Integer[first.length + second.length];

        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            answer[k++] = first[i] < second[j] ? first[i++] : second[j++];
        }

        while (i < first.length) {
            answer[k++] = first[i++];
        }

        while (j < second.length) {
            answer[k++] = second[j++];
        }

        return answer;

    }

    private Integer[] deleteDuplicatesFromArray(Integer[] array) {
        return Arrays.stream(array).distinct().toArray(Integer[]::new);
    }


    public static void main(String[] args) {


        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 100};

        TreeNode<Integer> head = new TreeNode<>(null);

        createBSTFromSortedArray(array, head);

    }
}
