import fint.Timer;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.LongStream;

public class Primes {

    public static List<Integer> primeFactors(int x) {

        List<Integer> factors = new ArrayList<>();
        int maxPrimeFactor = (int)Math.sqrt(x);
        BitSet allPrimes = primesFromSieve(maxPrimeFactor);

        int remaining = x;
        int trial = 2;

        while (trial * trial <= remaining && trial > -1) {
            if(remaining % trial == 0) {
                // trial is prime factor of x
                factors.add(trial);
                remaining = remaining / trial;
            }
            else {
                trial = allPrimes.nextSetBit(trial + 1);
            }
        }
        factors.add(remaining);
        return factors;
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

    //* Uses Sieve of Eratosthenes. Takes approx 1s to return first 100,000,000 primes
    public static BitSet primesFromSieve(int upto) {
        // true means it's a prime
        BitSet bs = new BitSet(upto + 1);
        // even numbers aren't prime, so we initialize intelligently. Takes ~ 15% of total method run time for 1e8
        // (future optimization if required: try initializing as longs with value 0x01010101010101...)
        bs.set(2);
        for (int i = 3; i <= upto ; i+=2) {
            bs.set(i);
        }
        // end of initialization.
        int max = (int) Math.sqrt(upto);
        // nextSetBit returns -1 if none exists so we have to check that i is still > 0
        for (int i = 3; i <= max && i > 0; i = bs.nextSetBit(i + 2)) {
            for (int j = i * 2; j < upto; j += i) {
                bs.clear(j);
            }
        }
        return bs;
    }


    // for testing purposes:
    public static void main(String[] args) throws Exception{
        Timer.timed(()-> {
//            BitSet b = primesFromSieve(100_000_000);
            System.out.println(primeFactors(53));
            return 0L;
        });
    }
}
