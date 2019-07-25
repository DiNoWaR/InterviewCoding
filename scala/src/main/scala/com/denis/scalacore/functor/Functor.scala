package com.denis.scalacore.functor

case class Functor[A](content: A) {

  def map[B](func: A => B): Functor[B] = Functor(func(content))

}
