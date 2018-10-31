import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

// A chance to try out the new java.time package

public class Euler_019 extends Problem {
    @Override
    long solve() throws IOException {
        final LocalDate start = LocalDate.of(1901,1,1);
        final LocalDate end = LocalDate.of(2000, 12, 31);
        int sundayCount = 0;
        LocalDate date = start;
        while(date.isBefore(end)||date.equals(end)) {
            if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) && date.getDayOfMonth() == 1) sundayCount++;
            date = date.plusDays(1);
        }
        return sundayCount;
    }
}
