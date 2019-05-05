package com.denis.scalacore.either

import scala.util.Left

object EitherEx {

  def divide(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) {
      Left("Bgg")
    } else Right(x / y)
  }


  def main(args: Array[String]): Unit = {

    divide(5, 0) match {
      case Left(message) => println(message)
      case Right(result) => println(result)
    }

  }

}
