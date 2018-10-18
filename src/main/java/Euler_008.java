import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Euler_008 extends Problem {
/*

The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
[see file]
Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
*/
    int numberOfDigits = 13;

    long solve() {
        URL number = getClass().getResource("Euler_008_data.txt");
        String x = "";
        try (Scanner sc = new Scanner(new File(number.toURI()))){
            StringBuilder sb = new StringBuilder();
            while(sc.hasNext()) {
                sb.append(sc.nextLine());
            }
            x = sb.toString();
            //System.out.println(sb.toString());
        }
        catch (Exception e) {e.printStackTrace();}

        long maxProduct = 0;
        char[] digits = x.toCharArray();
        for (int i = 0; i <= x.length() - numberOfDigits; i++) {
            long product = 1;
            for (int j = 0; j < numberOfDigits; j++) {
                product = product * Character.getNumericValue(digits[i+j]);
            }
            if(product > maxProduct) maxProduct = product;
        }
        return maxProduct;
    }

}
