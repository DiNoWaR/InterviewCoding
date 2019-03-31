package com.denis.arraypartition

import scala.util.control.Breaks._

object ArrayPartition {


  def partition(array: Array[Int], value: Int): Unit = {

    var left = 0
    var right = array.length - 1


    while (left < right) {

      if (array(left) >= value) {

        if (array(right) < value) {
          swap(left, right, array)
          left += 1
          right -= 1
        }
        else {
          right -= 1
        }
      }
      left += 1
    }

    val index = getIndexOfValue(array, value)
    swap(left + 1, index, array)

  }

  private def swap(fromIndex: Int, toIndex: Int, array: Array[Int]): Unit = {
    val temp = array(toIndex)
    array(toIndex) = array(fromIndex)
    array(fromIndex) = temp
  }

  private def getIndexOfValue(array: Array[Int], value: Int): Int = {

    var index = 0

    breakable {
      for (i <- 0 to array.length) {
        if (array(i) == value) {
          index = i
          break
        }
      }
    }
    index
  }


  def main(args: Array[String]): Unit = {

    var array = Array(10, 45, 332, 12, 34, 23, 1, 55)

    partition(array, 45)
    array.foreach(item => print(item + " "))

  }
}
