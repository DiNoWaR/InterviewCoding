package com.denis.algorithms.createbinarytree

import com.denis.interview.algorithms.binarytrees.traversal.dfs.DFSTraversals
import com.denis.interview.util.TreeNode

object CreateBinaryTree {


  def createBinaryTree(array: Array[Integer], root: TreeNode[Integer]): TreeNode[Integer] = {

    val n = array.length / 2

    if (array.length == 1) {
      root.setValue(array(0))
      return root
    }

    if (array.length == 2) {
      root.setValue(array(1))
      val leftElement = array.slice(0, 1)
      val leftNode = new TreeNode[Integer]()
      root.setLeft(createBinaryTree(leftElement, leftNode))
      return root
    }

    val left = array.slice(0, n)
    val right = array.slice(n + 1, array.length)

    val leftNode = new TreeNode[Integer]()
    val rightNode = new TreeNode[Integer]()

    root.setValue(array(n))
    root.setLeft(createBinaryTree(left, leftNode))
    root.setRight(createBinaryTree(right, rightNode))

    root

  }

  def main(args: Array[String]): Unit = {

    val array: Array[Integer] = new Array[Integer](150)

    var i = 0

    while (i < array.length) {
      array(i) = i
      i = i + 1
    }

    val root = createBinaryTree(array, new TreeNode[Integer]())
    DFSTraversals.inOrderTraversal(root)

  }
}
