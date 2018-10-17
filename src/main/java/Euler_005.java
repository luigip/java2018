import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler_005 extends Problem {
/*

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

    int upperLimit = 20;

    @Override
    long solve() {

        //return bruteForce();
        return cleverer();
    }

    long bruteForce() {
        // Start at 1 and test whether each number from 1 to upperLimit divides it evenly
        for (int i = 1; ; i++) {
            boolean success = true;
            for (int j = 1; j <= upperLimit ; j++) {
                if (i % j != 0) {success = false; break;}
            }
            if(success) return i;
        }
    }

    long cleverer() {
        // take prime factors of each number, and multiply maximum number of factors in range
        // e.g. 4 = 2 * 2, 6 = 3 * 2, 8 = 2 * 2 * 2, 10 = 5 * 2
        // so 2 required a maximum of 3 times in numbers up to 10
        Map<Long,Long> maxFactorCounts = new HashMap<Long, Long>();

        for (int i = 1; i < upperLimit; i++) {
            // get prime factors of i
            List<Long> factors = Primes.primeFactors(i);
            // count the frequencies of each prime factor
            Map<Long,Long> freqs = factors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            // keep track of the maximum number of each prime factor required
            for (Map.Entry<Long,Long> entry: freqs.entrySet()) {
                Long n = entry.getKey();
                Long count = entry.getValue();
                if(maxFactorCounts.getOrDefault(n,0L) < count)
                    maxFactorCounts.put(n,count);
            }
        }
//        System.out.println(maxFactorCounts);

        long total = maxFactorCounts.entrySet().stream()
                .map(entry -> (long)Math.pow(entry.getKey(), entry.getValue()))
                .reduce(1L, (acc, x) -> acc * x);

        return total;
    }

}
