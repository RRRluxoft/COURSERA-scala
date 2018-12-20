import progfun2.week4.frp.{Signal, Var}

object accountss {

  def consolidated(accts: List[BankAccount]): Signal[Var[Int]] =
    Signal(accts.map(_.balance).sum)

  val a = new BankAccount
  val b = new BankAccount
  val c = consolidated(List(a, b))
  c()
  a deposit 20
  c()
}