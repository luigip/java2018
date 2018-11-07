package euler

import euler.common.Primes

class Euler_007 extends Problem {
//  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//  What is the 10 001st prime number?

  override def solve(): Long = {
    val limit = 10001
    val ls = Primes.primesFrom2.limit(limit)
    ls.skip(limit - 1).findFirst.getAsLong
  }
}
