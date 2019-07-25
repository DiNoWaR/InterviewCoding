package com.denis.minmax

import scala.collection.mutable.ArrayBuffer

object MinMax {

  def getMinMax(size: Int, list: ArrayBuffer[Int]): Int = {

    if (size == 1) {
      list.max
    }

    else if (list.size == 1) {
      list.head
    }

    else if (size == list.size) {
      list.min
    }

    else {

      var max = 0

      var index = 0

      while (index <= list.size - size - 1) {

        val commonMin = list.slice(index + 1, index + size).min

        val left = Math.min(list(index), commonMin)
        val right = Math.min(list(index + size), commonMin)

        if (left > max) {
          max = left
        }

        if (right > max) {
          max = right
        }

        index = index + 1
      }
      max
    }
  }

}
