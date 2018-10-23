public class Euler_014 extends Problem {

//    private static int START = 13;
    private static int UNDER = 1_000_000;

    @Override
    long solve() {
        int maxSteps = 0;
        int nMax = 1;
        for (int i = 1; i < UNDER; i++) {
            int steps = iter(i, 1);
            if(steps > maxSteps) {maxSteps = steps; nMax = i;}
        }
        return nMax;
    }

    int iter(long n, int count){
        if(n == 1) return count;
        else return iter(next(n), count + 1);
    }

    long next(long n) {
        if (n % 2 == 0) return n/2;
        else return 3 * n + 1;
    }

}
