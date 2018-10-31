import java.nio.file.{Files, Paths}
import scala.collection.JavaConverters._

class Euler_018_and_067 extends Problem {

  def solve: Long = {
    def lineToInts(line: String) = line.split(" ").toList.map(_.toInt)
    val lines = Files.lines(Paths.get("data/Euler_067.txt")).iterator().asScala.toList.reverse.map(lineToInts)
    def maxTotals(xs: List[Int]) = xs match {
      case x :: Nil => xs
      case x :: rest => (xs,rest).zipped.map(_ max _)
    }
    def loop(xs: List[List[Int]], lastMaxes: List[Int]): Int = xs match {
      case Nil => lastMaxes.head
      case x :: rest => loop(rest, maxTotals((x, lastMaxes).zipped.map(_ + _)))
    }
    val zeros = List.fill(lines.head.length)(0)
    loop(lines, zeros)
  }

  // Original way:
  // This is over-complex since you don't actually need to construct a tree, you just need to convert the numbers
  // into their max totals with their neighbours
  def solve0: Long = {
    case class Number(maxTotal: Int, left: Number, right: Number)
    object End extends Number(0, null, null)
    val lines =
    Files.lines(Paths.get("data/Euler_067.txt")).iterator().asScala.toList.reverse
    def lineToInts(line: String) = line.split(" ").toList.map(_.toInt)
    val firstLine: List[Number] = lineToInts(lines.head).map(n => Number(n, End, End))
    def combine(line: List[Int], prev: List[Number]) =
      prev.sliding(2).toList.zip(line).map{
        case (List(a,b), i) => Number(i + (a.maxTotal max b.maxTotal), a, b)
      }
    def apex(lines: List[String], prevLine: List[Number]): Number = lines match {
      case Nil => prevLine.head
      case ls => apex(ls.tail, combine(lineToInts(ls.head), prevLine))
    }
    apex(lines.tail, firstLine).maxTotal
  }

}
