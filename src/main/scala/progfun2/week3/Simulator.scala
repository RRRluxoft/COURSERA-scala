package progfun2.week3

abstract class Simulator {
  type Action = () => Unit
  case class Event(time: Int, action: Action)
  private type Agenda = List[Event]
  private var agenda: Agenda = List()

  private var curtime = 0
  def currentTime: Int = curtime

  private def insert(ag: Agenda, item: Event): List[Event] = ag match {
    case first :: rest if first.time <= item.time =>
      first :: insert(rest, item)
    case _ =>
      item :: ag
  }

  private def loop(): Unit = agenda match {
    case first :: rest =>
      agenda = rest
      curtime = first.time
      first.action
      loop()
    case Nil =>
  }

  def run(): Unit = {
    afterDelay(0) {
      println("*** simulation started, time = " + currentTime + " ***")
    }
    loop()
  }

  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = Event(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }
}

