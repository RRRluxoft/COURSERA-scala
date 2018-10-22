
object exercise {
  val tolerance = 0.0001
  def isCLoseEnough(x: Double, y: Double) =
    math.abs((x - y) / x) / x < tolerance
  def fixedPoints(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCLoseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  fixedPoints(x => 1 + x/2)(1)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2

  def sqrt(x: Double) =
    fixedPoints(averageDamp(y => x/y))(1)

  sqrt(2)
}