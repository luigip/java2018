package euler.common

object Utilities {
  // common utility methods

  def concatenateInts(x: Int, y: Int) = {
    val sb = new StringBuilder
    sb.append(x)
    sb.append(y)
    sb.toString.toInt
  }
}
