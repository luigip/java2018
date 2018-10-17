class Euler_006 extends Problem {
  override def solve(): Long = {
    val numbers = 100
    val range = 1 to numbers
    val sumOfSquares = range.map(x => x * x).sum
    val sumOfRange = range.sum
    val squareOfSum = sumOfRange * sumOfRange
    squareOfSum - sumOfSquares
  }
}
