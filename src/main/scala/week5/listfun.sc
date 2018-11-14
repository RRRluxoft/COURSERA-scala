package week5

object listfun {

  val nums = List(1, -5, 4, 7, 6)
  val fruits = List("apple" , "pineapple" , "orange" , "banana")

  nums filter(x => x > 0)
  nums filterNot(x => x > 0)
  nums partition(x => x > 0)

  nums takeWhile(x => x > 0)
  nums dropWhile(x => x > 0)
  nums span(x => x > 0)

//  def f(i: Int): Int = i * i
  def squareList_(xs: List[Int]): List[Int] =
    xs match {
      case Nil => Nil
      case y :: ys => y * y :: squareList_(ys)
    }

  def squareList(xs: List[Int]): List[Int] =
    xs map (x => x * x)

  def posElem(xs: List[Int]): List[Int] = {
    xs match {
      case Nil => xs
      case y :: ys => if (y > 0) y :: posElem(ys) else posElem(ys)
    }
  }

  val data = List("a", "a", "a", "b", "c", "c", "a")

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil // xs
    case x :: xs1 =>
      val (first, rest) = xs span(y => y equals x )
      first :: pack(rest)
  }

  pack(data)

  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map (ys => (ys.head, ys.length))
  }

  encode(data)


}