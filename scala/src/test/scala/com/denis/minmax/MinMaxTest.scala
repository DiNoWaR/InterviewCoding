package com.denis.minmax

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer


class MinMaxTest extends FunSuite {

  test("1") {
    val input: ArrayBuffer[Int] = Array(0).to[ArrayBuffer]
    val result = MinMax.getMinMax(1, input)
    assert(result == 0)
  }

  test("2") {
    val input: ArrayBuffer[Int] = Array(0, 1).to[ArrayBuffer]
    val result = MinMax.getMinMax(1, input)
    assert(result == 1)
  }

  test("3") {
    val input: ArrayBuffer[Int] = Array(0, 1).to[ArrayBuffer]
    val result = MinMax.getMinMax(2, input)
    assert(result == 0)
  }

  test("4") {
    val input: ArrayBuffer[Int] = Array(0, 1, 2).to[ArrayBuffer]
    val result = MinMax.getMinMax(1, input)
    assert(result == 2)
  }

  test("5") {
    val input: ArrayBuffer[Int] = Array(0, 1, 2).to[ArrayBuffer]
    val result = MinMax.getMinMax(2, input)
    assert(result == 1)
  }

}
