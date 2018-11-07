package euler

class Euler_012 extends Problem {
  override def solve(): Long = {
    val divisors = 500
    val triangles = Stream.from(1).scanLeft(0)(_ + _).tail

    def countDivisors(x: Int, trial: Int = 1, count: Int = 0): Int =
      if (trial * trial > x) count * 2 //only need to go up to sqrt. then double count for x / trial
      else countDivisors(x, trial + 1, count + (if (x % trial == 0) 1 else 0))

    triangles.dropWhile(x => countDivisors(x) <= divisors).head
  }


}
