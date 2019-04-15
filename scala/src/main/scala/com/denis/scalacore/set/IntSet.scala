package com.denis.scalacore.set

abstract class IntSet {

  def include(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet

}
