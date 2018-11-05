import fint.Timer;

import java.util.*;
import java.util.stream.IntStream;
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

    public static boolean[] primesSieveBoolean(int upto) {
        boolean[] ps = new boolean[upto + 1];
        int max = (int) Math.sqrt(upto);
        // initialize odds to true
        ps[2] = true;
        for (int i = 3; i < ps.length; i+=2) {
            ps[i] = true;
        }
        // for each prime
        for (int i = 3; i <= max && i > -1; i = nextOddTrueAfter(ps, i)) {
            // set multiples of that prime to false
            for (int j = i * 2; j < ps.length; j += i) {
                ps[j] = false;
            }
        }
        return ps;
    }

    private static int nextOddTrueAfter(boolean[] arr, int p) {
        for (int i = p + 2; i < arr.length; i+=2) {
            if(arr[i]) return i;
        }
        return -1;
    }


    // for testing purposes:
    public static void main(String[] args) throws Exception{
        Object[] X = new Object[2];
        Timer.timed(()-> {
            X[0] = primesFromSieve(100_000_000);
            return 0L;
        });
//            System.out.println(primeFactors(53));
        Timer.timed(()-> {
            X[1] = primesSieveBoolean(100_000_000);
            return 0L;
        });
        BitSet b = (BitSet) X[0];
        boolean[] ps = (boolean[]) X[1];

        IntStream rs = (new Random()).ints(100, 0, 100_000_001);
        rs.forEach(r -> System.out.println(r + "BitSet "+b.get(r)+" boolean[] "+ps[r]+ (b.get(r)==ps[r]? " Korrect": " **** WONG ****")));
    }
}
