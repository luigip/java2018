package euler;//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//        a^2 + b^2 = c^2
//
//        For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//        There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//        Find the product abc.

public class Euler_009 extends Problem {

    long solve() {
        final int TARGET = 1000;
        for (int a = 1; a <= TARGET; a++) {
            for (int b = 1; b < TARGET - a; b++) {
                int c = TARGET - a - b;
                if(a*a + b*b == c*c) return a*b*c;
            }
        }
        return -1;
    }
}
