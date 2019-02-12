package com.denis.sort.countsort

import scala.collection.mutable
import scala.util.Random


object CountSort {

  def countSort(array: Array[Int]): Array[Int] = {

    val mapWithElementsAndCounts = array.groupBy(item => item).map(pair => (pair._1, pair._2.length))

    val indexArray = createIndexArray(array)

    val countSumArray = createCountSumArray(indexArray, mapWithElementsAndCounts)


    val newMap = new mutable.HashMap[Int, Int]

    var counter = 0
    indexArray.foreach({ item =>
      newMap += (item -> countSumArray(counter))
      counter = counter + 1
    })

    val sortedArray = new Array[Int](array.length)

    array.foreach(item => {
      val position = newMap(item) - 1
      sortedArray(position) = item
      newMap(item) = newMap(item) - 1
    })

    sortedArray

  }

  private def createIndexArray(array: Array[Int]): Array[Int] = {

    var min = array(0)
    var max = array(0)

    array.foreach(item => {
      if (item < min) {
        min = item
      }
      if (item > max) {
        max = item
      }
    })

    val indexArray = new Array[Int](max - min + 1)

    var counter = 0

    while (counter < indexArray.length) {
      indexArray(counter) = min
      counter = counter + 1
      min = min + 1
    }
    indexArray
  }

  private def createCountSumArray(array: Array[Int], mapa: Map[Int, Int]): Array[Int] = {

    val countSumArray = new Array[Int](array.length)

    var counter = 0
    var previousFrequency = 0
    var currentFrequency = 0

    array.foreach(item => {

      mapa.get(item) match {
        case Some(value) => {
          currentFrequency = previousFrequency + value
          previousFrequency = currentFrequency
          countSumArray(counter) = currentFrequency
          counter = counter + 1
        }
        case None => {
          currentFrequency = previousFrequency
          countSumArray(counter) = currentFrequency
          counter = counter + 1
        }
      }
    })

    countSumArray
  }


  def main(args: Array[String]): Unit = {

    val random = new Random()

    val array = new Array[Int](10000000)

    var counter = 0

    while (counter < array.length) {
      array(counter) = random.nextInt(100)
      counter = counter + 1
    }


    countSort(array).foreach(item => println(item))

  }

}
