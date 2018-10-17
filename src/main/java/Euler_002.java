import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Euler_002 extends Problem {

    class Pair {
        final int a;
        final int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    long solve() {

        Stream<Pair> pairs = Stream.iterate(new Pair(1,2),
                p -> new Pair(p.b, p.a + p.b));
        // Java 8 doesn't have takeWhile etc.
        List<Integer> fibb = new ArrayList<>();
        Iterator<Pair> it = pairs.iterator();
        Pair pair = it.next();
        while (pair.a < 4_000_000) {
            fibb.add(pair.a);
            pair = it.next();
        }
        //System.out.println(fibb);
        return fibb.stream()
                .filter(x-> x % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }


}
