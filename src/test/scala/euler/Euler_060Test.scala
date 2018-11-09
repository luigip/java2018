package euler

import org.scalatest.{FunSuite, Matchers}

class Euler_060Test extends FunSuite with Matchers {

  val e = new Euler_060

  test("testGetCombos") {
    e.getCombos(2, 10).toStream shouldEqual Stream(List(3, 7), List(3, 11))
    e.getCombos(3, 999).toStream shouldEqual Stream(List(3, 7, 109), List(3, 7, 229), List(3, 7, 541), List(3, 7, 673), List(3, 7, 823), List(3, 11, 701), List(3, 17, 449), List(3, 37, 67), List(3, 37, 607), List(3, 59, 929), List(3, 73, 607), List(3, 73, 823), List(3, 109, 673), List(3, 137, 191), List(3, 137, 359), List(3, 137, 947), List(3, 229, 373), List(3, 229, 499), List(3, 229, 613), List(3, 331, 739), List(3, 359, 701), List(3, 373, 823), List(3, 449, 557), List(3, 467, 617), List(3, 499, 673), List(3, 613, 673), List(3, 719, 947), List(7, 19, 97), List(7, 19, 433), List(7, 19, 937), List(7, 61, 487), List(7, 97, 829), List(7, 97, 883), List(7, 109, 673), List(7, 109, 883), List(7, 229, 433), List(7, 229, 547), List(7, 229, 937), List(7, 283, 487), List(7, 283, 541), List(7, 433, 883), List(7, 487, 757), List(7, 523, 541), List(7, 547, 823), List(7, 547, 853), List(7, 757, 829), List(11, 23, 743), List(11, 251, 941), List(13, 19, 577), List(13, 19, 709), List(13, 19, 997), List(13, 61, 331), List(13, 103, 997), List(13, 127, 241), List(13, 127, 331), List(13, 331, 577), List(13, 523, 577), List(17, 83, 449), List(17, 389, 971), List(19, 31, 181), List(19, 31, 991), List(19, 163, 997), List(19, 433, 571), List(19, 577, 937), List(19, 727, 997), List(23, 311, 677), List(23, 311, 827), List(23, 677, 827), List(29, 179, 383), List(29, 347, 401), List(31, 139, 907), List(31, 991, 1009), List(37, 79, 967), List(37, 313, 991), List(37, 607, 967), List(37, 607, 991), List(41, 227, 593), List(41, 227, 719), List(41, 593, 863), List(41, 719, 911), List(43, 499, 691), List(47, 149, 251), List(59, 197, 971), List(59, 419, 929), List(67, 139, 547), List(67, 139, 619), List(71, 257, 263), List(71, 263, 443), List(71, 263, 821), List(71, 389, 947), List(71, 389, 971), List(71, 719, 947), List(71, 821, 971), List(73, 547, 643), List(73, 547, 823), List(79, 367, 613), List(83, 227, 719), List(83, 443, 701), List(83, 449, 563), List(83, 719, 773), List(83, 719, 911), List(89, 431, 983), List(89, 443, 983), List(89, 521, 809), List(89, 809, 821), List(89, 809, 983), List(97, 241, 883), List(101, 197, 641), List(101, 467, 641), List(109, 139, 661), List(109, 199, 673), List(109, 661, 883), List(109, 859, 919), List(113, 233, 983), List(127, 157, 733), List(127, 241, 271), List(127, 241, 601), List(131, 449, 941), List(137, 197, 947), List(137, 239, 947), List(137, 353, 359), List(137, 659, 947), List(137, 743, 947), List(139, 367, 457), List(139, 547, 661), List(139, 547, 709), List(139, 547, 787), List(139, 709, 967), List(149, 251, 491), List(149, 251, 971), List(149, 563, 971), List(163, 193, 811), List(163, 193, 883), List(163, 307, 367), List(163, 367, 613), List(163, 613, 883), List(163, 811, 997), List(167, 521, 641), List(179, 269, 317), List(181, 193, 283), List(181, 193, 751), List(181, 199, 751), List(181, 283, 397), List(181, 421, 607), List(181, 607, 619), List(181, 751, 787), List(191, 227, 281), List(193, 283, 541), List(193, 283, 601), List(193, 373, 1009), List(193, 433, 883), List(193, 433, 1009), List(199, 211, 373), List(199, 379, 751), List(199, 379, 811), List(199, 379, 877), List(199, 739, 751), List(211, 313, 727), List(211, 349, 373), List(211, 349, 499), List(223, 229, 547), List(223, 337, 919), List(227, 281, 719), List(229, 373, 937), List(233, 239, 347), List(233, 251, 347), List(233, 347, 983), List(233, 617, 983), List(233, 881, 983), List(239, 509, 947), List(239, 641, 929), List(241, 313, 727), List(241, 601, 823), List(241, 691, 727), List(241, 727, 823), List(257, 263, 293), List(263, 443, 761), List(263, 647, 821), List(269, 617, 887), List(277, 751, 787), List(281, 509, 797), List(283, 487, 601), List(293, 311, 827), List(293, 467, 617), List(307, 523, 577), List(311, 677, 827), List(311, 821, 827), List(331, 577, 937), List(337, 349, 919), List(337, 691, 919), List(347, 443, 983), List(349, 409, 709), List(349, 709, 967), List(379, 751, 997), List(379, 811, 997), List(379, 877, 997), List(409, 691, 709), List(419, 443, 701), List(419, 449, 563), List(431, 929, 983), List(439, 541, 661), List(439, 613, 661), List(457, 757, 829), List(461, 479, 569), List(463, 613, 829), List(467, 587, 617), List(479, 821, 971), List(547, 661, 769), List(547, 709, 823), List(547, 787, 823), List(613, 661, 883), List(631, 739, 751), List(661, 877, 883), List(683, 719, 911), List(709, 823, 967), List(719, 911, 947), List(733, 883, 991), List(809, 821, 827), List(809, 929, 983), List(821, 827, 857))
    e.getCombos(5,9999).toStream shouldEqual Stream(List(13, 5197, 5701, 6733, 8389))
  }

  test("testIsRemarkablePair") {

  }

  test("testIsRemarkable") {
    e.isRemarkable(Seq(3,7,109), 673) shouldEqual true
    e.isRemarkable(Seq(3,7,107), 673) shouldEqual false
    e.isRemarkable(Seq(3,7,109), 671) shouldEqual false
  }

  test("Example solution") {
    val e2 = new Euler_060 {
      override val numberOfPrimesInSet = 4
      override val maxSearch: Int = 700
    }
    e2.solve shouldEqual 792
  }

}
