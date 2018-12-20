package progfun2.week3

class BankAccount {
  private var balance = 0
  def deposit(amount: Int): Unit =
    if (amount > 0) {balance = balance + amount
      balance
  }
  def withdraw(amount: Int): Unit =
    if (0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    } else throw new Error("insufficient funds")

}
