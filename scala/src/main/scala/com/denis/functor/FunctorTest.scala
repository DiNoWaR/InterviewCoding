package com.denis.functor

object FunctorTest {

  // the guy who is expert at making sugar half
  def half: Sugar => Sugar = (sugar: Sugar) => Sugar(sugar.weight / 2)

  val sugarBag: Bag[Sugar] = Bag(Sugar(1))

  //Bag functor of type sugar
  // map is the guy in our story who can perform operations
  // by unwrapping the bag and then calling respective function
  // and wraps the content back in a bag
  val halfSugarBag: Bag[Sugar] = sugarBag.map(sugar => half(sugar))


  def main(args: Array[String]): Unit = {

    val x: Option[Int] = Some(4)
    val y: Int = 2
    val m: Int = 2

    val mapResult = x.map(a => (a + y) * m)
    val flatMapResult = x.flatMap(item => Option(item * 2))

    println(mapResult)
    println(flatMapResult)

  }

}
