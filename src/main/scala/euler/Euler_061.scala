package euler

//    Amazingly this worked first time. Not the most elegant, and the recursion probably needs some work. In particular
//    I wasn't happy about mapping all members in the sets onto the recursive function. Seems like I should be able to
//    do this lazily and only as much as needed
//    Time: 845598899 ns  =  846 ms
//      euler.Euler_061: 28684
class Euler_061 extends Problem {
  def solve: Long = {

    val setSize = 6
    val sizes = 3 until 3 + setSize

    def P(sides: Int, n: Int) = sides match {
      case 3 => n*(n+1)/2
      case 4 => n*n
      case 5 => n*(3*n-1)/2
      case 6 => n*(2*n-1)
      case 7 => n*(5*n-3)/2
      case 8 => n*(3*n-2)
    }

    case class Value(v: Int, sides: Int, n: Int) {
      val left: Int = v / 100
      val right: Int = v % 100
      lazy val leftCompatible: Set[Value] = allValues.filter(_.right == left)
      lazy val rightCompatible: Set[Value] = allValues.filter(_.left == right)
    }

    lazy val series: Map[Int, Stream[Value]] = (for {
      sides <- sizes.toVector
      } yield sides -> Stream.from(1).map(n => Value(P(sides, n), sides, n)).dropWhile(_.v < 1000).takeWhile(_.v <= 9999)
      ).toMap

    lazy val allValues = series.values.flatten.toSet

    def findValid(parent: Value, nsRequired: Set[Int], result: Vector[Value]): Option[Vector[Value]] =
      nsRequired.size match {
        case 0 => result.head.leftCompatible.find(_ == parent) match {
          case Some(v) => Some(result :+ v)
          case None => None
        }
        case _ => {
          val nextPossibleValues: Set[Value] = parent.rightCompatible.filter(v => nsRequired.contains(v.sides) && !result.contains(v))
          nextPossibleValues.toStream.map(value => findValid(value, nsRequired - value.sides, result :+ value)).find(_.isDefined).flatten
        }
      }

    val result: Vector[Value] = series(3).map(value => findValid(value, sizes.toSet, Vector.empty[Value])).find(_.isDefined).get.get
    result.map(_.v).init.sum

  }
}
