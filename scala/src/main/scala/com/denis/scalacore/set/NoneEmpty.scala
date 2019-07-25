package com.denis.scalacore.set


class NoneEmpty(value: Int, left: IntSet, right: IntSet) extends IntSet {

  override def include(x: Int): IntSet = {

    if (x < value) {
      new NoneEmpty(value, left.include(x), right)
    }
    else if (x > value) {
      new NoneEmpty(value, left, right.include(x))
    }
    else this
  }

  override def contains(x: Int): Boolean = {

    if (x < value) {
      left.contains(x)
    }
    else if (x > value) {
      right.contains(x)
    }
    else true
  }

  override def union(other: IntSet): IntSet = {
    left.union(right).union(other).include(value)
  }
}
