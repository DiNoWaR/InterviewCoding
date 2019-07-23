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

    val firstSet: TreeSet[Student] = new TreeSet[Student]()(StudentAgeOrdering)
    val secondSet: TreeSet[Student] = new TreeSet[Student]()(StudentNameOrdering)
    val thirdSet: TreeSet[Student] = new TreeSet[Student]()

    firstSet += petr
    firstSet += artem
    firstSet += artem2
    firstSet += artem22
    firstSet += artem3
    firstSet += denis

    secondSet += petr
    secondSet += artem
    secondSet += artem2
    secondSet += artem22
    secondSet += artem3
    secondSet += denis

    thirdSet += petr
    thirdSet += artem
    thirdSet += artem2
    thirdSet += artem22
    thirdSet += artem3
    thirdSet += denis

    firstSet.foreach(student => println(student))
    println("----------------------------------")
    secondSet.foreach(student => println(student))
    println("----------------------------------")
    thirdSet.foreach(student => println(student))


  }
}
