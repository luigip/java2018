package fint;

import java.io.IOException;

public class Timer<T> {
    public static long timed(Timing task) throws IOException {
        return timed(task, 1);
    }

    public static long timed(Timing task, int numberOfTimes) throws IOException {
        // We do the task twice. First is a warm-up and is discarded.
        for (int i = 0; i < numberOfTimes - 1; i++) {
            task.doTaskToBeTimed();
        }
        long t0 = System.nanoTime();
        long result = task.doTaskToBeTimed();
        long t1 = System.nanoTime();
        long time = t1 - t0;
        System.out.println("Time: "+time+" ns  =  "+ Math.round(time/1_000_000.0) +" ms");
        return result;
    }
}