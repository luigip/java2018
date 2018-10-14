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
        int[] maxFactorCounts = new int[upperLimit+1];
        for (int i = 1; i < upperLimit; i++) {
            // get prime factors of i
            List<Long> factors = Primes.primeFactors(i);
            // count the frequencies of each prime factor
            Map<Long,Long> freqs = factors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            // keep track of the maximum number of each prime factor required
            for (Map.Entry<Long,Long> entry: freqs.entrySet()) {
                int n = entry.getKey().intValue();
                int count = entry.getValue().intValue();
                if(maxFactorCounts[n] < entry.getValue()) {
                    maxFactorCounts[n] = count;
                }
            }
        }
        //System.out.println(Arrays.toString(maxFactorCounts));

        // get total
        long total = 1;
        for(int i = 1; i < maxFactorCounts.length; i++){
            int number = maxFactorCounts[i];
            if (number > 0) total = total * ((long)Math.pow(i,number));
        }


        return total;
    }
    
}
