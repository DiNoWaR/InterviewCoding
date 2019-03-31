package com.denis.scalacore.ordering

case class Student(name: String, lastName: String, age: Int) extends Ordered[Student] {

  override def compare(that: Student): Int = {

    if (this.name > that.name) {
      1
    }

    else if (this.name == that.name) {

      if (this.lastName > that.lastName) {
        1
      }

      else if (this.lastName == that.lastName) {

        if (this.age > that.age) {
          1
        }
        else -1
      }
      else -1
    }
    else -1
  }

}

