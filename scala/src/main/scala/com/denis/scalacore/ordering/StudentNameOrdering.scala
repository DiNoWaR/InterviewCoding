package com.denis.scalacore.ordering

object StudentNameOrdering extends Ordering[Student] {

  override def compare(x: Student, y: Student): Int = {
    if (x.name > y.name) {
      1
    }
    else -1
  }
}
