package com.denis.scalacore.set

object Empty extends IntSet {

  override def include(x: Int): IntSet = new NoneEmpty(x, Empty, Empty)

  override def contains(x: Int): Boolean = false

  override def union(other: IntSet): IntSet = other
}
