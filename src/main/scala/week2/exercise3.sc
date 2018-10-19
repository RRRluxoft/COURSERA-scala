object exercise3 {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  }
}

val actual: Int = exercise3.product(x => x * x)(3, 5)
val result: Int = 3 * 3 * 4 * 4 * 5 * 5
