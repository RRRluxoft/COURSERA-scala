//package progfun2.week4

class Consolidator(observed: List[BankAccount]) extends Subscriber {
//  observed.map(_.currentBalance).sum

  private var total: Int = sum()

  private def sum() =
    observed.map(_.currentBalance).sum

  override def handler(pub: Publisher): Unit = sum()

  def totalBalance = total
}
