

object parallel {
  class HelloThread extends Thread {
    private var uidCount = 0
    private val x = new AnyRef{}


    def getUidCount(): Long = x.synchronized {
      uidCount = uidCount + 1
      uidCount
    }

    def startThread(): Unit = {
      var t = new Thread{
        override def run(): Unit = {
          val ids = for (i <- 1 to 10) yield getUidCount()
          println(ids)
        }
      }
      t.start()
    }

    override def run(): Unit = {
      println("Hello Scala!")
    }
  }
  val t = new HelloThread
  val t2 = new HelloThread
//  t.start()
//  t2.start()
//  t.join()
//  t2.join()
//  t.getUidCount()
//  t2.getUidCount()

  t.startThread()
  t.startThread()

  case class Account( var amount: Int = 0) {


    def getAmount() = this.amount
    val uid = getAmount()

    private def lockAndTransfer(target: Account, n: Int) = {
      this.synchronized {
        target.synchronized {
          this.amount -= n
          target.amount += n
        }
      }
    }

    def transfer(target: Account, n: Int) = {
      if (this.uid < target.amount) this.lockAndTransfer(target, n)
      else target.lockAndTransfer(this, -n)
    }


  }

  val acc1 = new Account(100)
  val acc2 = new Account(10)
  acc1.transfer(acc2, 10)
  println(s"amount", acc1.amount)
  println(s"amount", acc2.amount)
}