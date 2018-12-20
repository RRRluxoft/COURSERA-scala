import progfun2.week4.{Signal, Var}

object accountss {

  def Signal(sum: Var) = ???

  def consolidated(accts: List[BankAccount]): Signal[Int] =
    Signal(accts.map(_.balance).sum)

  val a = new BankAccount
  val b = new BankAccount
  val c = consolidated(List(a, b))
  c()
  a deposit 20
  c()
}