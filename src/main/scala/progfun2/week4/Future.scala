package progfun2.week4

import scala.util.{Failure, Success, Try}

trait Future[T] {

//  def onCompete(callBack: Try[T] => Unit) = ???

//  def flatMap[S](f: T => Future[S]): Future[S] = ???

  self => def flatMap[S](f: T => Future[S]): Future[S] =
    new Future[S] {
      def onCompete(callBack: Try[T] => Unit): Unit =
        self onCompete {
          case Success(x) => f(x).onComplete(callBack)
          case Failure(e) => callBack(Failure(e))
        }
    }

}
