package fint;

import java.io.IOException;
import java.util.function.Supplier;

public class Timer<T> {
    public static final Timer<Long> TimerLong = new Timer<>();
    public static final Timer<Integer> TimerInt = new Timer<>();
    public static final Timer<Object> TimerObject = new Timer<>();
    public static final Timer Timer = new Timer<>();

    public T timed(Supplier<T> task) throws IOException {
        return timed(task, 1);
    }

    public T timed(Supplier<T> task, int numberOfTimes)  {
        // We do the task twice. First is a warm-up and is discarded.
        for (int i = 0; i < numberOfTimes - 1; i++) {
            task.get();
        }
        long t0 = System.nanoTime();
        T result = task.get();
        long t1 = System.nanoTime();
        long time = t1 - t0;
        System.out.println("Time: "+time+" ns  =  "+ Math.round(time/1_000_000.0) +" ms");
        return result;
    }
}