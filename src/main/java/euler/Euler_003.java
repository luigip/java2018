package euler;

/* The prime factors of 13195 are 5, 7, 13 and 29.
   What is the largest prime factor of the number 600851475143 ?
*/
public class Euler_003 extends Problem {
    long solve() {
        return lpf(600_851_475_143L,2);
    }

    long lpf(long n, long f) {
        if (f*f > n) return n;
        else if (n % f == 0) return lpf(n / f, f);
        else return lpf(n, f + 1);
    }

}
