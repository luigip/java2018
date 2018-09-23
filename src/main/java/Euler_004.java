/* A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
   Find the largest palindrome made from the product of two 3-digit numbers. */

import java.util.ArrayList;

public class Euler_004 extends Problem {

    long solve() {
        ArrayList<Integer> pals = new ArrayList<>();
        for (int i = 100; i < 1000 ; i++) {
            for (int j = 100; j < 1000; j++) {
                if(isPalindrome(String.valueOf(i*j))) pals.add(i*j);
            }
        }
        return pals.stream().mapToLong(Integer::intValue).max().getAsLong();
    }

    boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

}
