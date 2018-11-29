import scala.annotation.tailrec

object tail {

  @tailrec  
  def list1[T](n: Int)(k: List[Int] => T): List[Int] => T =  
  if (n <= 0) k
  else list1(n - 1)(
    l => k(n :: l)
  )

  var t = list1(2)(identity)

  list1(2)(t)

}