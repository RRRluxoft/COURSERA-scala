import progfun2.week4.Var
//package progfun2.week4

class BankAccount /*extends Publisher*/ {
  var balance = Var(0)

//  def currentBalance: Int = balance

  def deposit(amount: Int): Unit =
    if (amount > 0) {
      val b = balance()
      balance() = b + amount
//      publish()
    }

  def withdraw(amount: Int): Unit =
    if (0 < amount && amount <= balance()) {
      val b = balance()
      balance() = b - amount
//      publish()
    } else throw new Error("insufficient funds")

}
