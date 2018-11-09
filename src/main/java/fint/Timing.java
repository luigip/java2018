package fint;
import java.io.IOException;

@FunctionalInterface
public interface Timing<T> {
    T doTaskToBeTimed() throws IOException;
}

