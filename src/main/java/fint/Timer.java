package fint;

import java.io.IOException;

public class Timer<T> {
    public static long timed(Timing task) throws IOException {
        long t0 = System.nanoTime();
        long result = task.doTaskToBeTimed();
        long t1 = System.nanoTime();
        long time = t1 - t0;
        System.out.println("Time: "+time+" ns  =  "+ Math.round(time/1_000_000.0) +" ms");
        return result;
    }
}