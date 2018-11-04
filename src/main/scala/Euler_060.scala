class Euler_060 extends Problem {
// Haven't done this one before. Difficultly rating is higher
/* Prime pair sets
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order
the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these
four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
*/
  // Strategy:
  // As any two primes concatenate, any set of four within the set of five is also a 'remarkable' set
  // So look for sets of five by adding another prime to sets of four
  // Similarly, get sets of four from sets of three, from sets of two

  def solve: Long = {
    val numberOfPrimesInSet = 4

    ???
  }

  def isRemarkable(xs: Set[Int]) = {

  }



}
