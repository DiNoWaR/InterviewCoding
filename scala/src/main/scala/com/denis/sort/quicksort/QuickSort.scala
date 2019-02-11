package com.denis.sort.quicksort

object QuickSort {

  def qsort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case pivot :: tail => {
      val (smaller, rest) = tail.partition(_ < pivot)
      qsort(smaller) ::: pivot :: qsort(rest)
    }
  }


}
