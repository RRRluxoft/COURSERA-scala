
object parallelMapping {
  List(1, 3, 8).map(x => x * x)

  List(1, 3, 8).fold(100)((a, b) => a + b)

  List(1, 3, 8).scan(100)((a, b) => a + b)

  def mapSeq[A, B](list: List[A], f: A => B): List[B] = list match {
    case Nil => Nil
    case x :: xs => f(x) :: mapSeq(xs, f)
  }

  mapSeq[Int, Int](List(1, 3, 8), x => x * x)

  def mapSegSeq[A, B](inp: Array[A], left: Int, right: Int, f: A => B, out: Array[B]): Unit = {
//    for left <= i <= right - 1
    var i = left
    val mid = left + (right - left) / 2
    while (i < right) {
      out(i) = f(inp(i))
      i += 1
    }
    //parallel(
    mapSegSeq(inp, left, mid, f, out) //,
    mapSegSeq(inp, mid, right, f, out)
    //)
  }

  val inp = Array(1, 2, 3, 4, 5)
  val f = (x: Int) => x * x
  val out = Array(0, 0, 0, 0, 100)
  mapSegSeq(inp, 1, 3, f, out)
  out

}