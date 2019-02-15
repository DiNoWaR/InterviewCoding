package com.denis.sort.mergesort

import scala.collection.mutable.ListBuffer

/**
  *
  */
object MergeSort {

  def mergeSort(list: List[Int]): List[Int] = {

    val n = list.length / 2

    if (n == 0) list

    else {
      val (left, right) = list.splitAt(n)
      merge(mergeSort(left), mergeSort(right), new ListBuffer[Int]).toList
    }
  }

  private def merge(first: List[Int], second: List[Int], result: ListBuffer[Int]): ListBuffer[Int] = {

    (first, second) match {

      case (left, Nil) => {
        left.copyToBuffer(result)
        result
      }

      case (Nil, right) => {
        right.copyToBuffer(result)
        result
      }

      case (leftHead :: leftTail, rightHead :: rightTail) =>
        if (leftHead < rightHead) {
          result += leftHead
          merge(leftTail, second, result)
        }
        else {
          result += rightHead
          merge(first, rightTail, result)
        }
    }
  }

}
