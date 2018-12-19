package progfun2.week2

object test {

  println("Pouring")

  val problem = new Pouring(Vector(4, 9))
  problem.moves

  problem.pathSets.take(3).toList

  problem.solution(6)
}