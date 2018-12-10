import scala.annotation.tailrec

object tail {

  @tailrec  
  def list1[T](n: Int)(k: List[Int] => T): List[Int] => T =  
  if (n <= 0) k
  else list1(n - 1)(
    l => k(n :: l)
  )

  val t = list1(1000)(identity)

  println (list1(2)(t))

}