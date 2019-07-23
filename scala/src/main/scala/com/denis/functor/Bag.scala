package com.denis.functor

case class Bag[A](content: A) {
  def map[B](f: A => B): Bag[B] = Bag(f(content))
}

case class Sugar(weight: Double)


