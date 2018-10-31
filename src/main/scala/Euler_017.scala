class Euler_017 extends Problem {
  def solve: Long = {
    val letters = for {
      x <- 1 to 1000
      char <- numberToWord(x)
      if char.isLetter
    } yield char
    letters.length
  }

  def numberToWord(x: Int): String = {
    assert(1 to 1000 contains x)
         if (1 to 19 contains x) s1to19(x)
    else if (20 to 99 contains x) s20to90(x/10*10) + (if (x%10 != 0) "-" + numberToWord(x%10) else "")
    else if (100 to 999 contains x) numberToWord(x/100) + " hundred" + (if(x%100 != 0) " and " + numberToWord(x%100))
    else "one thousand"
  }

  private val s1to19 = (1 to 19).zip("one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen"
    .split(" ")).toMap
  private val s20to90 = (20 to 90 by 10).zip("twenty thirty forty fifty sixty seventy eighty ninety"
    .split(" ")).toMap
}


//// test
//    for {
//      x <- Seq(1,8, 15, 20, 21, 99, 100, 101, 888, 700, 1000)
//    } println(x + " is " + numberToWord(x))
