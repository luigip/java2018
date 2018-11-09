package euler

import euler.common.Primes
import euler.common.Utilities.concatenateInts

/*
  Prime pair sets
  The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order
  the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these
  four primes, 792, represents the lowest sum for a set of four primes with this property.

  Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
*/

// Strategy:
// As any two primes concatenate, any set of four within the set of five is also a 'remarkable' set
// So look for sets of five by adding another prime to sets of four
// Similarly, get sets of four from sets of three, from sets of two

class Euler_060 extends Problem {
  private val numberOfPrimesInSet = 4
  private val primes = Primes.primesFromSieve(1e6.toInt)

  def solve: Long = {
//    for {
//      setSize <- 2 to numberOfPrimesInSet
//    }
    0L
  }

  def `pairs where n = 2`(upto: Int): Set[Set[Int]] = {
//    for {
//      p1 <- primes.stream.iterator.asScala.takeWhile(_ <= upto)
//      p2 <- primes.stream.iterator.asScala.dropWhile(_ <= p1).takeWhile(_ <= upto)
//    } ???
    ???
  }

  def isRemarkable(xs: Set[Int]) =
    xs.toIndexedSeq.combinations(2).forall(combo => primes.get(concatenateInts(combo(0), combo(1))))



}
object Test_060 extends App {
  val e = new Euler_060
  val r = concatenateInts(12,34)
  println(r)
}
