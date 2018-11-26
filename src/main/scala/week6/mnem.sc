

object mnem {

//  val in = Source.fromURL("http://")
//  val words = in.getLines.toList filter (word => word forall (char => char.isLetter))
//
//  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
//  '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
//
////  Invert map mnemonic
//  val charCode: Map[Char, Char] =
//    for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit
//
//  def wordCode(word: String): String =
//    word.toUpperCase map charCode
//
//  wordCode("Java")
//
//  val wordsForNum: Map[String, Seq[String]] =
//    words groupBy wordCode withDefaultValue Seq()
//  def encode(number: String): Set[List[String]] =
//    if (number.isEmpty) Set(List())
//    else {
//      for {
//        split <- 1 to number.length
//        word <- wordsForNum(number take split)
//        rest <- encode(number drop split)
//      } yield word :: rest
//    }.toSet
//
//  encode("7225")
//
//  def transalte(number: String): Set[String] =
//    encode(number) map (_ mkString " ")

  val head = List(1, 3)
  val tail = List(5, 7)
  head ::: tail
  head ::: Nil

//  val a = List(1, 3, 5, 7)
//  a.reduceLeft(_ * _)

  val d = Nil
  val c = 3 :: d
  val b = 2 :: c
  val a = 1 :: b
  a
  a.tail
  b.tail
  c.tail

}