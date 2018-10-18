import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Primes {

    public static List<Long> primeFactors(long x) {

        List<Long> primes = new ArrayList<>();
        long remaining = x;
        long trial = 2;

        while (trial * trial <= remaining) {
            long remainder = remaining % trial;
            if(remainder == 0) {
                // trial is prime factor of x
                primes.add(trial);
                remaining = remaining / trial;
            }
            else {
                trial ++;
            }
        }
        primes.add(remaining);
        return primes;
    }

    public static boolean isPrime(long x) {
        for (long n = 2; n <= Math.sqrt(x); n++) {
            if (x % n == 0) {
                return false;
            }
        }
        return true;
    }

    public static LongStream primesFrom2 =
            LongStream.iterate(2, Primes::nextPrimeAfter);


    public static long nextPrimeAfter(long x){
        long y = x+1;
        if(isPrime(y)) return y;
        else return nextPrimeAfter(y);
    }

//    private static long primeAfterOdd(long x){
//        // nb only use this if you know x is odd. We don't check, for efficiency.
//
//    }


    // for testing purposes:
    public static void main(String[] args) {
        System.out.println(primeFactors(24));
    }
}
