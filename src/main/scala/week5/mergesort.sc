package week5

import math.Ordering

object mergesort {
println("Start mergesort ...")
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge[T](xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil , ys) => ys
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(msort(fst) /*(ord)*/, msort(snd) /*(ord)*/ )
    }
  }

  val nums = List(1, -5, 4, 7, 6)
  val fruits = List("apple" , "pineapple" , "orange" , "banana")

  msort(nums)//(Ordering.Int)
  msort(fruits)//(Ordering.String)

}
