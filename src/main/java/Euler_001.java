import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Euler_001 {
    public static void main(String[] args) {
        System.out.println(solution3(1000));
    }

    // Old way
    static int solution(int below) {
        int total = 0;
        for (int i = 0; i < below; i++) {
            if(i % 3 == 0 || i % 5 == 0) total = total + i;
        }
        return total;
    }

    // Naive new way first attempt!
    static int solution2(int below) {
        List<Integer> xs = new ArrayList<>();
        for (int i = 0; i < below; i++) {
            xs.add(i);
        }
        xs.removeIf(x -> x % 3 != 0 && x % 5 != 0);
        // mapToInt required for unboxing; i -> i also works
        int result = xs.stream().mapToInt(Integer::intValue).sum();
        return result;
    }

    // Better
    static int solution3(int below) {
        return IntStream.range(0,below)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .sum();
    }

}
