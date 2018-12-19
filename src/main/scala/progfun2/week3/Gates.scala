package progfun2.week3

abstract class Gates extends Simulator {

  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int

  class Wire {
    private var sigVal = false
    private var actions: List[Action] = Nil
    def getSignal: Boolean = sigVal
    def setSignal(s: Boolean): Unit =
      if (s != sigVal) {
        sigVal = s
        actions foreach (_()) // for (a <- actions) a()
      }
    def addAction(a: Action): Unit = {
      actions = a :: actions
      a()
    }
  }

  def inverter(input: Wire, output: Wire): Unit = {
    def invertAction(): Unit = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) {output setSignal !inputSig}
    }
  }

  def andGate(a1: Wire, a2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val in1Sig = a1.getSignal
      val in2Sig = a2.getSignal
    afterDelay(AndGateDelay) {output setSignal (in1Sig & in2Sig)}
    }
    a1.addAction(andAction)
    a2 addAction andAction
  }

  def orGate(o1: Wire, o2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val in1Sig = o1.getSignal
      val in2Sig = o2.getSignal
      afterDelay(OrGateDelay) {output setSignal (in1Sig & in2Sig)}
    }
    o1 addAction andAction
    o2 addAction andAction
  }

  def orGateAlt(in1: Wire, in2: Wire, output: Wire): Unit = {
    val notIn1, notIn2, notOut = new Wire
    inverter(in1, notIn1); inverter(in2, notIn2)
    andGate(notIn1, notIn2, notOut)
    inverter(notOut, output)
  }

  def probe(name: String, wire: Wire): Unit = {
    def probeAction(): Unit = {
      println(s"$name $currentTime new-value = ${wire.getSignal}")
    }
    wire addAction probeAction
  }

}
