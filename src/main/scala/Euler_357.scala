import java.util
import collection.mutable.ArrayBuffer

class Euler_357 extends Problem {
  private val max_n = 1e8.toInt
  private val primes: util.BitSet = Primes.primesFromSieve(max_n + 1)

  def solve: Long = {
    /*
    Strategy:
    Observe the following:
      - if d is the product of a subset of the prime factors of n, then n/d is the product of all the rest
          e.g. if n = a*b*c*d*e, if d = a*b then n/d = c*d*e
      - all solutions > 1 must contain factor 2 (since they need to add to give a prime, which is odd)
      - all solutions can have max of 1 factor of each prime (since otherwise there exist divisors with
        a common factor in d and n/d, hence sum divides by that factor and is not prime)
      - BIG CLUE: since 1 and n are included in the dividers, when d = 1, d + n/d = n + 1, which is required
          to be prime. Therefore only check n where n is a prime - 1.

    Hence:
      - start with primes - 1
      - narrow down candidates to test by eliminating numbers that have more than 1 of the same prime factor
      - do this by factorization, i.e. dividing by the factors found already

    Or, another optimization: divisors can more quickly be calculated by taking previous n with same prime factors and
    adding multiples of the new prime factor to the list (doubling the number of divisors). i.e. create a cache of
    cartesian products
    */

    (for {
      (n, factors) <- candidates(max_n)
      if isPrimeGenerator(n, cartesianProduct(factors))
    } yield n.toLong).sum

//    Time: 13440653799 ns  =  13441 ms
//    Euler_357: 1739023853137
//    Correct!

  }

  def candidates(upto: Int): ArrayBuffer[(Int, ArrayBuffer[Int])] = {
    // This method combines the operations:
    // 1. Iterating through all possible numbers
    // 2. Working out prime factors
    val results = ArrayBuffer[(Int, ArrayBuffer[Int])]()
    results += (1 ->  ArrayBuffer[Int](1))
    var n = 2
    while(n <= upto && n > -1) {
      //println("n = " + n)
      primeFactors(n) match {
        case Some(list) => results += (n -> list)
        case None =>
      }
      n = primes.nextSetBit(n + 2) - 1
    }
    results
  }

  def primeFactors(n: Int): Option[ArrayBuffer[Int]] = {
    // takes a pre-screened n and returns Some(factors) unless n has repeated prime factors
    val factors = ArrayBuffer[Int]()  // storage for prime factors
    var remaining = n  // what's left after we divide through by the prime
    var prime = 2
    // only go up to sqrt of trial, since we know there aren't any smaller factors (we've already
    // divided them out), hence there cannot be any larger than the sqrt
    while (prime * prime <= remaining && prime > -1) {
      if (remaining % prime == 0) { // trial is prime factor of x
        factors += prime
        remaining = remaining / prime
        if (remaining % prime == 0) { /*println(s"$remaining % $prime == 0");*/ return None}
      }
      prime = primes.nextSetBit(prime + 1)
    }
    factors += remaining
    Some(factors)
  }
  def isPrimeGenerator(n: Int, divisors: List[Int]): Boolean = {
    // This could be optimized if divisors were in (d, n/d) pairs, since it's the same for (n/d, d), i.e. twice the speed
    divisors.forall(d => primes.get(d + n/d))
  }

  def cartesianProduct(xs: Seq[Int]) =
    xs.map(x => List(1, x)).reduceLeft((ys, zs) => for(y <- ys; z <- zs) yield y * z)

}

