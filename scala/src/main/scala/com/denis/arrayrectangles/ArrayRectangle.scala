package com.denis.arrayrectangles

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._


object ArrayRectangle {

  def getRectangle(array: Array[Array[Int]]): Rectangle = {

    var leftX = 0
    var leftY = 0

    breakable {

      for (i <- array.indices) {
        for (j <- array(i).indices) {
          if (array(i)(j) == 0) {
            leftX = i
            leftY = j
            break()
          }
        }
      }

    }

    findRectangle(leftX, leftY, array)
  }

  def getMultipleRectangles(array: Array[Array[Int]]): ArrayBuffer[Rectangle] = {

    val result = new ArrayBuffer[Rectangle]
    val visitedArray: Array[Array[Boolean]] = Array.ofDim[Boolean](array.length, array(0).length)

    var found = true

    breakable {

      while (found) {

        found = false

        var leftX = 0
        var leftY = 0

        breakable {

          for (i <- array.indices) {
            for (j <- array(i).indices) {
              if (array(i)(j) == 0 && !visitedArray(i)(j)) {
                leftX = i
                leftY = j
                found = true
                break()
              }
            }
          }
        }

        if (!found) {
          break()
        }

        val rectangle = findRectangle(leftX, leftY, array)
        result += rectangle

        var targetHeight = leftX + rectangle.height
        var targetWidth = leftY + rectangle.width

        var currentHeight = leftX
        var currentWidth = leftY

        while (currentHeight < targetHeight) {
          val currentArray = visitedArray(currentHeight)

          while (currentWidth < targetWidth) {
            currentArray(currentWidth) = true
            currentWidth = currentWidth + 1
          }

          currentHeight = currentHeight + 1
          currentWidth = leftY
        }

      }

    }

    result
  }


  private def findRectangle(leftX: Int, leftY: Int, array: Array[Array[Int]]): Rectangle = {

    var height = 0
    var width = 0

    breakable {
      val currentArray = array(leftX)

      for (i <- leftY until currentArray.length) {
        if (currentArray(i) == 0) {
          width = width + 1
        }
        else break
      }

    }

    breakable {

      for (i <- leftX until array.length) {
        if (array(i)(leftY) == 0) {
          height = height + 1
        }
        else break
      }
    }

    Rectangle(leftX, leftY, width, height)

  }


  def printArray(array: Array[Array[Int]]) = {
    for (i <- array.indices) {
      for (j <- array(i).indices) {
        print(array(i)(j) + " ")
      }
      println()
    }
  }


  def main(args: Array[String]): Unit = {

    val array1 = Array(
      Array(1, 1, 1, 1, 1),
      Array(1, 0, 0, 0, 1),
      Array(1, 0, 0, 0, 1),
      Array(1, 0, 0, 0, 1),
      Array(1, 1, 1, 1, 1)
    )

    val array2 = Array(
      Array(0, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1)
    )

    val array3 = Array(
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 0)
    )

    val array4 = Array(
      Array(0, 0, 1, 1, 1),
      Array(0, 0, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1),
      Array(1, 1, 1, 1, 1)
    )

    //---------------------------------------------

    val array5 = Array(
      Array(0, 1, 0, 1, 1),
      Array(1, 1, 0, 1, 1),
      Array(1, 1, 0, 1, 1),
      Array(1, 1, 0, 1, 1),
      Array(1, 1, 0, 1, 0)
    )

    println(getRectangle(array1))
    println(getRectangle(array2))
    println(getRectangle(array3))
    println(getRectangle(array4))
    println(getMultipleRectangles(array5))
  }

}
