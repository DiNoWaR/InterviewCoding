package com.denis.scalacore.higherorderfunc


object HigherOrderFunctions {

  /**
    * -------------------------------------------------
    */
  def id(item: Int): Int = item

  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else id(a) + sumInts(a + 1, b)
  }


  /**
    * -------------------------------------------------
    */
  def cube(a: Int): Int = {
    a * a * a
  }

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  }


  /**
    * -------------------------------------------------
    */
  def factorial(a: Int): Int = {
    if (a == 1) 1 else a * factorial(a - 1)
  }

  def sumFactorials(a: Int, b: Int): Int = {
    if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
  }


}

sealed trait HigherOrderFunctions {

  /**
    * Auxillary functions for summation function
    * -------------------------------------------------
    */
  def id(item: Int): Int = item

  def cube(a: Int): Int = {
    a * a * a
  }

  def factorial(a: Int): Int = {
    if (a == 1) 1 else a * factorial(a - 1)
  }


  /**
    * Generic summation function with recursion and tail recursion
    * -------------------------------------------------
    */
  def sum(func: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else func(a) + sum(func, a + 1, b)
  }

  def sumTailRec(func: Int => Int, a: Int, b: Int): Int = {

    def loop(a: Int, accum: Int): Int = {

      if (a > b) {
        accum
      } else {
        loop(a + 1, accum + func(a))
      }
    }

    loop(a, 0)
  }


  /**
    * Concrete summation functions using
    * -------------------------------------------------
    */
  def sumInts(a: Int, b: Int): Int = sumTailRec(id, a, b)

  def sumCubes(a: Int, b: Int): Int = sumTailRec(cube, a, b)

  def sumFactorials(a: Int, b: Int): Int = sumTailRec(factorial, a, b)

}