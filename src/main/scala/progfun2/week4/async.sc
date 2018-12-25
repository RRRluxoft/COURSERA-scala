
object async {

  List(a, b, c).foldRight(e)(f)
//  equivalent
  f(a, f(b, f(c, e)))
//  =====================


  List(a, b, c).foldLeft(e)(f)
//  equivalent
  f(f(f(e, a), b), c)

}