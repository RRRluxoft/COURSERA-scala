
object test {
  val xs = Array(2, 6, -4, 7)
  xs map (x => x + 1)

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
  val n = 7
  isPrime(n)
  isPrime(8)
  isPrime(2)
}