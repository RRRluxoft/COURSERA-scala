import java.util.concurrent.ConcurrentSkipListSet

import scala.collection.{GenSeq, GenSet}

object data_parallel {

  (1 until 100).par
    .filter(e => e % 3 == 0)
    .count(p => p.toString == p.toString.reverse)

  def sum(xs: Array[Int]): Int = {
          xs.par.fold(0)(_ + _)
//    var r = 0
//    (0 until xs.length).par // xs.indices
////      .foreach(e => r += xs(e))
//      .foldLeft(0)(xs(_) + xs(_))
  }

  def max(xs: Array[Int]): Int = {
    xs.par.fold(Int.MinValue)(math.max)
//    equivalent
//    xs.par.fold(Int.MinValue)((a,b) => if (a > b) a else b)
  }

  def play(a: String, b: String): String = List(a, b).sorted match {
    case List("paper", "scissor") => "scissor"
    case List("paper", "rock") => "paper"
    case List("rock", "scissor") => "rock"
    case List(a, b) if a == b => a
    case List("", b) => b
  }

  sum(Array[Int](1, 2, 3))

  max(Array(7, -100, 1))

  play("rock", "paper")
  Array("paper", "rock", "paper", "scissor", "rock")
    .par
    .fold("")(play)

  def isVowel(c: Char): Boolean = c match {
    case 'a' | 'A' => true
    case 'e' | 'E' => true
    case 'i' | 'I' => true
    case 'o' | 'O' => true
    case 'y' | 'Y' => true
    case _ => false

  }

  Array('A', 'E', 'B', 'F').par
    .aggregate(0)(
      (count, c) => if (isVowel(c)) count+1 else count,
      _ + _)

  def intersection(ax: GenSet[Int], bx: GenSet[Int]) = {
    val result = new ConcurrentSkipListSet[Int]()
//    ax.intersect(bx)
    for (x <- ax) if (bx contains x) result add x
    result

//    or :
    if (ax.size > bx.size) bx.filter(ax(_))
    else ax.filter(bx(_))
  }

  sealed trait Iterator[T] {
    def hasNext: Boolean
    def next(): T
    def foldLeft[S](z: S)(f: (S, T) => S): S =  {
      var result = z
      while (hasNext) result = f(result, next())
      result
    }
  }

  trait Splitter[A] extends Iterator[A] {
    def split: Seq[Splitter[A]]
    def remaining: Int
  }

//  def splitter: Splitter[A]
//  for(x <- this)  if(p(x))  b += x

}