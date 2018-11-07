package euler

import euler.common.Primes

/*
  Strategy:
  Observe the following:
    - if d is the product of a subset of the prime factors of n, then n/d is the product of all the rest
        e.g. if n = a*b*c*d*e, if d = a*b then n/d = c*d*e
    - all solutions can have max of 1 factor of each prime (since otherwise there exist divisors with
        a common factor in d and n/d, hence sum divides by that factor and is not prime)
    - since 1 and n are included in the dividers, when d = 1, d + n/d = n + 1, which is required
        to be prime

  Hence:
    - start with list of primes.map(_ - 1)
    - narrow down candidates to test by eliminating numbers that have more than 1 of the same prime factor
    - do this by factorization, i.e. dividing by the factors found already
    - Therefore only check n where n is a prime - 1.

  Or, another optimization: divisors can more quickly be calculated by taking previous n with same prime factors and
  adding multiples of the new prime factor to the list (doubling the number of divisors). i.e. create a cache of
  cartesian products

      Full version, max_n = 1e8
      Time:  =  1859 ms (1052 ms if run twice)
      Euler_357: 1739023853137

      Short version, max_n = 1e6
      Time:  =  739 ms
      Euler_357: 524402305
  */
class Euler_357 extends Problem {

  private val max_n = 1e8.toInt
  private val primes: java.util.BitSet = Primes.primesFromSieve(max_n + 1)    // A Sieve of Eratosthenes

  def solve: Long = {
    val solutions = for {
      p <- Iterator.iterate(2)(p => primes.nextSetBit(p + 1)).takeWhile(_ <= max_n / 2)
      n = 2 * (p - 2)
      if primes.get(n + 1)
      factors <- primeFactors(n)
      if isSolution(n, cartesianProduct(factors))
    } yield n.toLong
    // We left out the solution 1, because it doesn't fit the n / 2 + 2 pattern, so add it:
    1 + solutions.sum
  }

  def primeFactors(remaining: Int, prime: Int = 2, factors: Vector[Int] = Vector.empty): Option[Seq[Int]] = {
    // primes returns -1 if it has run out of primes
    // primes above the sqrt(remaining) can't be factors, but we know the remaining is the last prime
    def nextPrime = primes.nextSetBit(prime + 1)
    if (prime * prime <= remaining && prime > -1) remaining % prime match {
      case 0 => remaining / prime % prime match {         // prime divides, check if it divides again
        case 0 => None                                    // repeated prime factor, hence invalid
        case _ => primeFactors(remaining / prime, nextPrime, factors :+ prime)
      }
      case _ => primeFactors(remaining, nextPrime, factors)  // does not divide, so try next prime
    }
    else Some(factors :+ remaining)
  }

  def isSolution(n: Int, divisors: Seq[Int]): Boolean =
    divisors.forall(d => primes.get(d + n/d))

  def cartesianProduct(xs: Seq[Int]): Seq[Int] =
    xs.map(x => List(1, x)).reduceLeft((ys, zs) => for(y <- ys; z <- zs) yield y * z)
}
