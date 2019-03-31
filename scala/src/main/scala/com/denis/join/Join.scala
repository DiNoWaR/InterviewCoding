package com.denis.join

import scala.collection.mutable.ArrayBuffer

object Join {

  def sortedMergeJoin(first: List[Int], second: List[Int]): List[Int] = {

    val sortedFirst = first.sorted
    val sortedSecond = second.sorted

    sortedFirst.withFilter(item => item < 12)

    val result: ArrayBuffer[Int] = new ArrayBuffer[Int]()

    var i = 0
    var j = 0


    while (i < sortedFirst.length && j < sortedSecond.length) {

      if (sortedFirst(i) > sortedSecond(j)) {
        j += 1
      }

      else if (sortedFirst(i) == sortedSecond(j)) {
        result += sortedFirst(i)
        i += 1
      }
      else {
        i += 1
      }
    }

    result.toList
  }

  def hashJoin(first: List[Int], second: List[Int]): List[Int] = {

    val result: ArrayBuffer[Int] = new ArrayBuffer[Int]()

    var small: List[Int] = first
    var big: List[Int] = second

    if (second.size < first.size) {
      small = second
      big = first
    }

    val mapa: Map[Int, List[Int]] = small.groupBy(item => item)

    big.foreach(item => {

      mapa.get(item) match {
        case None =>
        case Some(value) => value.foreach(element => result += element)
      }

    })

    result.toList
  }

  def nestedLoopsJoin(first: List[Int], second: List[Int]): List[Int] = {

    val result: ArrayBuffer[Int] = new ArrayBuffer[Int]()

    first.foreach(firstItem => {
      second.foreach(secondItem => {
        if (secondItem == firstItem) {
          result += secondItem
        }
      })
    })

    result.toList
  }


  def main(args: Array[String]): Unit = {

    val first = List(0, 1, 10, 15, 16, 18, 5, 1)
    val second = List(10, 100, 4, 1, 18, 5, 6, 16)

    val firstResult = sortedMergeJoin(first, second)
    val secondResult = hashJoin(first, second)
    val thirdResult = nestedLoopsJoin(first, second)

    firstResult.foreach(item => print(item + " "))
    println("")
    println("-------------------")
    secondResult.foreach(item => print(item + " "))
    println("")
    println("-------------------")
    thirdResult.foreach(item => print(item + " "))

  }

}
