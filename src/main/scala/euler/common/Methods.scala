package euler.common

object Methods {
  // common utility methods

  def concatenateInts(x: Int, y: Int): Int = {
    val sb = new StringBuilder
    sb.append(x)
    sb.append(y)
    sb.toString.toInt
  }
}
