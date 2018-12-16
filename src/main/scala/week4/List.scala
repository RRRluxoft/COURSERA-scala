package week4


trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend [U >: T] (elem: U): List[U] = new Cons[U](elem, this)
  def f(xs: List[NonEmpty], x: Empty): List[IntSet] = xs prepend x
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  def singleton[T](elem: T) = new Cons[T](elem, Nil)

  def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException("Empty list")
    else if (n == 0 ) xs.head
    else nth(n - 1, xs.tail)
  }
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

abstract class IntSet {

}

class Empty extends IntSet {

}

class NonEmpty extends IntSet {

}


object List {
  //  List(1,2)
  def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons[T](x2, Nil))
  //List()
  def apply[T]: List[T] = Nil
}

object test {
  val x: List[String] = Nil

  def insert(x: Int, xs: scala.List[Int]): scala.List[Int] = xs match {
    case scala.List() => scala.List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }
}
