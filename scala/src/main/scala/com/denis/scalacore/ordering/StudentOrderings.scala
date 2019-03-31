package com.denis.scalacore.ordering

object StudentOrderings extends Ordering[Student] {

  override def compare(x: Student, y: Student): Int = {
    if (x.age > y.age) {
      1
    }
    else -1
  }

}
