package com.denis.scalacore.currying

/**
  *
  */
object Currying {


  def sum(func: Int => Int): (Int, Int) => Int = {

    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0 else func(a) + sumF(a + 1, b)
    }

    sumF
  }

  def mapReduce(mapFunc: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {

    if (a > b) {
      zero
    } else {
      combine(mapFunc(a), mapReduce(mapFunc, combine, zero)(a + 1, b))
    }
  }

  def product(mapFunc: Int => Int)(a: Int, b: Int): Int = mapReduce(mapFunc, (x, y) => x * y, 1)(a, b)


  def main(args: Array[String]): Unit = {
    println(product(x => x)(1, 5))
  }

}
