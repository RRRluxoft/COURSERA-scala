package week6


object pairs {
  val n = 7

//  1 <= j < i < n
//  (1 until n) map (i =>
//    (1 until i) map (j => (i, j)))

def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)
//or
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))

  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    (for ((x, y) <- xs zip ys) yield x * y).sum

}