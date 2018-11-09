package euler.common

import java.util

class BitSetIterator(bitset: util.BitSet, from: Int, to: Int) extends Iterator[Int]  {
  private var index = from
  override def hasNext: Boolean = index <= to && bitset.nextSetBit(index) > -1
  override def next(): Int = {
    val result = bitset.nextSetBit(index)
    index = result + 1
    result
  }
}

object BitSetIterator {
  def apply(bitset: util.BitSet, from: Int, to: Int) = new BitSetIterator(bitset: util.BitSet, from: Int, to: Int)

  // testing
  def main(args: Array[String]): Unit = {
    val ps = Primes.primesFromSieve(20)
    val it = BitSetIterator(ps, 0, 20)
    println(it.sum)
  }
}