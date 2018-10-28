import scala.annotation.tailrec

object exercise3 {

  def mapReduce(f: Int => Int,
                combine: (Int, Int) => Int,
                zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

  def product(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b)

  product(x => x * x)(3, 4)

  def fact(n: Int) = product(x => x)(1, 5)
  fact(5)

  def factorial(x: Int): Int = {
    @tailrec
    def loop(acc: Int, x: Int): Int = {
      if (x == 0) acc else
        loop(acc * x, fact(x - 1))
    }
    loop(1, x)
  }

}

