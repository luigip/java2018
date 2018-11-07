package euler;/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

import euler.common.Primes;

import java.util.Iterator;

public class Euler_010 extends Problem {

    private static final long MAX = 2_000_000;

    long solve() {
        Iterator<Long> ps = Primes.primesFrom2.iterator();
        long sum = 0;
        for (long p = ps.next(); p < MAX; p = ps.next()) {
            sum += p;
        }
        return sum;
    }
}
