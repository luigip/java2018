package fint;
import java.io.IOException;

@FunctionalInterface
public interface Timing {
    long doTaskToBeTimed() throws IOException;
}

