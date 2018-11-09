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

  // completely gratuitous DSL coming up...
  class BitSetIteratorFrom(val from: Int) {
    def to(to: Int)(implicit bitset: util.BitSet) = BitSetIterator(bitset, from, to)
  }
  def from(start: Int)(implicit bitset: util.BitSet): BitSetIteratorFrom = new BitSetIteratorFrom(start)


  // testing
  def main(args: Array[String]): Unit = {
    implicit val ps = Primes.primesFromSieve(20)
    val it = BitSetIterator from 0 to 20
    println(it.sum)
  }
}

