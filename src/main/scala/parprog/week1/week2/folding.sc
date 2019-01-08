
object folding {
  List(1, 3, 8).map(x => x * x)
  List(1, 3, 8).fold(100)((a, b) => a + b)
  List(1, 3, 8).scan(100)((a, b) => a + b)
  List(1, 3, 8).reduce((a, b) => a + b)

  List(1, 3, 8).foldLeft(100)((a, b) => a - b)
  List(1, 3, 8).foldRight(100)((a, b) => a - b)
  List(1, 3, 8).reduceLeft((a, b) => a - b)
  List(1, 3, 8).reduceRight((a, b) => a - b)


}