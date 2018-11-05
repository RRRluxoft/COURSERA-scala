package week3

class Rational(x: Int, y: Int) {
  require(y != 0 , "denominator cannot be zero!")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numer: Int = x / g
  def denom: Int = y / g

  def < (that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom
  def > (that: Rational): Boolean = !(this < that)

  def max (that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.numer
    )

  def neg: Rational = new Rational(-numer, denom)

  def - (that: Rational) = this + that.neg

  override def toString: String = numer + "/" + denom
}
