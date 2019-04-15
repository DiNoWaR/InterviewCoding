package com.denis.algorithms.maxmin

import scala.collection.mutable.ArrayBuffer


object MaxMin {


  def segment(size: Int, list: ArrayBuffer[Int]): Int = {

    if (size == 1) {
      list.max
    }

    if (list.size == 1) {
      list.head
    }

    if (size == list.size) {
      list.min
    }

    else {

      val minList: ArrayBuffer[Int] = new ArrayBuffer()

      var index = 0

      while (index <= list.size - size) {

        val min = list.slice(index, index + size).min
        minList += min

        index = index + 1
      }
      minList.max
    }
  }


  def main(args: Array[String]): Unit = {

    val buffer: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    val array: List[Int] = List(5, 6, 8, 11, 3)

    array.copyToBuffer(buffer)

    println(segment(4, buffer))

  }
}
