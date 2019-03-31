package com.denis.scalacore.ordering

import scala.collection.mutable.TreeSet

object OrderingEx {

  def main(args: Array[String]): Unit = {

    val petr = Student("Petya", "Pupkin", 20)
    val artem = Student("Artem", "Kashpirev", 27)
    val artem2 = Student("Artem", "Abramov", 27)
    val artem22 = Student("Artem", "Abramov", 18)
    val artem3 = Student("Artem", "Ivanov", 27)
    val denis = Student("Denis", "Vasilyev", 32)

    val set: TreeSet[Student] = new TreeSet[Student]()(StudentOrderings)

    set += petr
    set += artem
    set += artem2
    set += artem22
    set += artem3
    set += denis

    set.foreach(student => println(student))

  }
}
