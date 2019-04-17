package com.denis.arraypartition

object ArrayPartition {


  def partition(array: Array[Int], value: Int): Unit = {

    var left = 0
    var right = array.length - 1


    while (left <= right) {

      if (array(left) >= value) {

        if (array(right) <= value) {
          swap(left, right, array)
          right -= 1
        }
        else {
          right -= 1
        }
      } else {
        left += 1
      }
    }

  }

  private def swap(fromIndex: Int, toIndex: Int, array: Array[Int]): Unit = {
    val temp = array(toIndex)
    array(toIndex) = array(fromIndex)
    array(fromIndex) = temp
  }


  def main(args: Array[String]): Unit = {

    val array = Array(10, 45, 332, 12, 34, 23, 1, 55, 37)

    partition(array, 12)
    array.foreach(item => print(item + " "))

  }
}
