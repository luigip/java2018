package euler

import scala.collection.mutable

/*Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.
How many such routes are there through a 20×20 grid? */

class Euler_015 extends Problem {
  def solve1: Long = {
    // Start at bottom right. Work back, assigning the number of ways of getting to the end to each intersection.
    // This could be solved more easily by a simple Pascal's Triangle calculation, but this is the Scala way to model
    // the problem
    val gridsize = 20
    sealed trait Intersection {
      val ways: Long
    }
    case object Edge extends Intersection {
      val ways = 0
    }
    case class Node(x: Int, y: Int) extends Intersection {
      val across: Intersection =
        if (x == 0) Edge else Node(x - 1, y)
      val down: Intersection =
        if (y == 0) Edge else Node(x, y - 1)
      val ways: Long =
        if (down == Edge && across == Edge) 1 // Endpoint
        else across.ways + down.ways
    }
    object Node {
      private val cache = mutable.Map[(Int, Int), Node]()
      def apply(x: Int, y: Int): Node = cache.getOrElseUpdate((x,y), new Node(x,y))
    }

    Node(gridsize, gridsize).ways
  }

  def solve: Long = {
    // A more convoluted but purer way without using co-ordinates or a mutable cache
    // Effectively we have a 2D analogue of a LinkedList, stitched together by growing in two directions
    // Amazingly, this worked first time. It's also 20x faster!
    val gridsize = 20
    sealed trait Intersection {
      val ways: Long
    }
    case object Edge extends Intersection {
      val ways = 0
    }
    case class Node(across: Intersection, down: Intersection) extends Intersection {
      val ways: Long = across.ways + down.ways
    }
    object Zero extends Node(Edge, Edge) {
      override val ways = 1
    }
    def growLeft(corner: Intersection): Intersection = corner match {
      case Edge => Edge
      case Node(_, down) => Node(corner, growLeft(down))
    }
    def growUp(corner: Intersection): Intersection = corner match {
      case Edge => Edge
      case Node(across, _) => Node(growUp(across), corner)
    }
    def grid(rowsToAdd: Int, corner: Intersection): Intersection = rowsToAdd match {
      case 0 => corner
      case n => grid(n - 1, Node(growUp(corner), growLeft(corner)))
    }
    grid(gridsize, Zero).ways
  }


}
