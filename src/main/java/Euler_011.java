/*
In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
[see data file]

        The product of these numbers is 26 × 63 × 78 × 14 = 1788696.

        What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
*/

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Euler_011 extends Problem {

    long solve() throws IOException {
        int runLength = 4;
        int squareSize = 20;
        File file = new File("data/Euler_011_data.txt");
        String input = Files.asCharSource(file, Charset.defaultCharset()).read();
        String[] inputStrings = input.split("\\r\\n|\\n| ");
        int[] xs = Arrays.stream(inputStrings).mapToInt(Integer::valueOf).toArray();
        int maxProduct = 1;
        for (int x = 0; x < squareSize; x++) {
            for (int y = 0; y < squareSize; y++) {
                int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};
                for (int[] dir : directions) {
                    int product = 1;
                    boolean valid = true;
                    for (int i = 0; i < runLength; i++) {
                        int x1 = x + dir[0] * i;
                        int y1 = y + dir[1] * i;
                        if (x1 >= squareSize || x1 < 0 || y1 >= squareSize || y1 < 0) {
                            valid = false;
                            break;
                        }
                        product *= xs[x1 + y1 * squareSize];
                    }
                    if (valid && product > maxProduct) maxProduct = product;
                }
            }
        }
        return maxProduct;
    }
}
