package week4

import org.omg.CosNaming.NamingContextPackage.NotEmpty

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend [U >: T] (elem: U): List[U] = new Cons[U](elem, this)
  def f(xs: List[NonEmpty], x: Empty): List[IntSet] = xs prepend x
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  def singleton[T](elem: T) = new Cons[T](elem, Nil[T])

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
}
