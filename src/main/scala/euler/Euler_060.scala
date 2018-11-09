package euler

import java.util

import euler.common.Methods.concatenateInts
import euler.common.{BitSetIterator, Primes}

/*
  Prime pair sets
  The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order
  the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these
  four primes, 792, represents the lowest sum for a set of four primes with this property.

  Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
*/

// Strategy:
// As any two primes concatenate, any set of four within the set of five is also a 'remarkable' set
// So look for sets of five by adding another prime to sets of four etc
// Similarly, get sets of four from sets of three, from sets of two

class Euler_060 extends Problem {
  /*private*/ val numberOfPrimesInSet = 5
  /*private*/ val maxSearch = 9999 // this is enforced if we're checking for primes of Ints from our sieve, as Int.MaxValue
  // is 9 digits, and we need to check check for concatenations
  implicit /*private*/ val primes: util.BitSet = Primes.primesFromSieve(1e8.toInt) // covering all 8 digit numbers

  def solve: Long = {
    getCombos(numberOfPrimesInSet, maxSearch).map(_.sum).max
    //    Time: 4891287217 ns  =  4891 ms
    //    euler.Euler_060: 26033
  }

  def pairCombos(max: Int): Stream[Set[Int]] = (for {
    p <- BitSetIterator from 0 to max
    q <- BitSetIterator from (p + 1) to max
    if isRemarkablePair(p, q)
  } yield Set(p, q)).toStream

  lazy val isPairCombo: Set[Set[Int]] = pairCombos(maxSearch).toSet

  def getCombos(arity: Int, max: Int): Stream[Set[Int]] = arity match {
    case 2 => pairCombos(max)
    case x => for {
      remarkableSet <- getCombos(x - 1, max)
      p <- BitSetIterator from (remarkableSet.max + 1) to max
      if isRemarkable(remarkableSet, p)
    } yield remarkableSet + p
  }

  def isRemarkablePair(x: Int, y: Int) = primes.get(concatenateInts(x, y)) && primes.get(concatenateInts(y, x))

  def isRemarkable(xs: Set[Int], p: Int) = xs.forall(x => isPairCombo(Set(x, p)))
}

// lessons from debugging:
// 1. Beware Iterators! Be careful you're not re-using them. Use Stream instead if possible