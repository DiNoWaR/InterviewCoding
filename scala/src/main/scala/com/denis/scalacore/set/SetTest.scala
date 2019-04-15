package com.denis.scalacore.set

object SetTest {

  def main(args: Array[String]): Unit = {

    val set = new NoneEmpty(100, Empty, Empty)
    val newSet = set.include(25).include(120)

    print("bgg")

  }

}
