package week6

object test {
  val xs = Array(2, 6, -4, 7)
  xs map (x => x + 1)

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
  val n = 7
  isPrime(n)
  isPrime(8)
  isPrime(2)

  val s = "Hello Scala"
  s filter(c => c.isUpper)

  val r: Range = 1 until 10
  val r2: Range = 1 to -5 by -2

}