import java.nio.file.{Files, Paths}
import scala.collection.JavaConverters._

class Euler_013 extends Problem {
  override def solve(): Long = {

    // You could of course do this with scala.io.Source. But here it is using the new Java 8 classes from nio.

    val numbers = Files.lines(Paths.get("data/Euler_013_data.txt")).iterator.asScala
    val sum = numbers.map(BigInt(_)).sum
    sum.toString.take(10).toLong
  }
}
