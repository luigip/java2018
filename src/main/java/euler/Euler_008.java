package euler;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Euler_008 extends Problem {
/*
The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
[see file in /data]
Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
*/
    int numberOfDigits = 13;

    long solve() {
        long maxProduct = 0;
        try {
            String x = Files.lines(Paths.get("data/Euler_008_data.txt")).collect(Collectors.joining());
            char[] digits = x.toCharArray();
            // loop over digits in input
            for (int i = 0; i <= x.length() - numberOfDigits; i++) {
                long product = 1;
                // loop over substring
                for (int j = 0; j < numberOfDigits; j++) {
                    product = product * Character.getNumericValue(digits[i+j]);
                }
                if(product > maxProduct) maxProduct = product;
            }
        } catch (Exception e) {e.printStackTrace();}
        return maxProduct;
    }

}
