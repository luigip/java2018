import com.sun.crypto.provider.DESedeKeyGenerator

import scala.collection.mutable

/*Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.
How many such routes are there through a 20×20 grid? */

class Euler_015 extends Problem {
  def solve: Long = {
    val gridsize = 20
    val cache: mutable.Map[(Int, Int), Intersection] = mutable.Map()
    // Start at bottom right. Work back, assigning the number of ways of getting to the end to each intersection.
    // This could be solved more easily by a simple Pascal's Triangle calculation, but this is the Scala way to model
    // the problem
    sealed trait Intersection {
      val ways: Long
    }
    case object Edge extends Intersection {
      val ways = 0
    }
    case class Node(x: Int, y: Int) extends Intersection {
      val across: Intersection =
        if (x == 0) Edge
        else cache.getOrElseUpdate((x - 1, y), Node(x - 1, y))
      val down: Intersection =
        if (y == 0) Edge
        else cache.getOrElseUpdate((x, y - 1), Node(x, y - 1))
      val ways: Long =
        if (down == Edge && across == Edge) 1 // Endpoint
        else across.ways + down.ways
    }
    Node(gridsize, gridsize).ways
  }
}
