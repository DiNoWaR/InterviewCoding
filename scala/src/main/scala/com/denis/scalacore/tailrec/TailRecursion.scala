package com.denis.scalacore.tailrec

import scala.annotation.tailrec

object TailRecursion {

  def factorial(value: Int): Int = {
    if (value == 1) 1 else value * factorial(value - 1)
  }

  @tailrec
  def factorialTail(value: Int, acc: Int = 1): Int = {
    if (value == 1) acc else factorialTail(value - 1, acc * value)
  }


  def main(args: Array[String]): Unit = {
    println(factorial(10))
    println(factorialTail(10))
  }
}
