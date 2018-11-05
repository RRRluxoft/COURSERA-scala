
object inset {
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 4
  t1.toString
  t2.toString
}

var ne1 = new NonEmpty(3, Empty, Empty)
var ne2 = ne1 incl 4
ne1.toString
ne2.toString
var empt = Empty

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  override def incl(x: Int) = new NonEmpty(x, Empty, Empty)
  override def contains(x: Int) = false
  override def union(other: IntSet) = other

  override def toString = "_"
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def union(other: IntSet) = ((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"
}