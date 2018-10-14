import java.util.ArrayList;
import java.util.List;

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

    // for testing purposes:
    public static void main(String[] args) {
        System.out.println(primeFactors(24));
    }
}
