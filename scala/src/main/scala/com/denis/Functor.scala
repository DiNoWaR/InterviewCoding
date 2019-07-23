package com.denis

case class Functor[A](content: A) {

  def map[B](func: A => B): Functor[B] = Functor(func(content))

}
