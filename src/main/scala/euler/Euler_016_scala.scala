package euler

class Euler_016_scala extends Problem {
  def solve: Long = {
    val exponent = 1000
    val power = BigInt(2).pow(exponent)
    val digits = power.toString.map(_.asDigit)
    digits.sum
  }
}
