import java.io.IOException;

public class Runner {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No problem specified. Class name of problem needs to be passed as an argument.\n" +
                    "Try editing the run configuration.");
            return;
        }
        String problemName = args[0];
        try {
            Problem problem = (Problem) Class.forName(problemName).getConstructor().newInstance();
            long result = timed(problem);
            System.out.println(problemName + ": " + result);
        }
        catch (RuntimeException r) {
            System.out.println("Boom, runtime exception!");
            System.out.println(r.toString().replaceAll("[^a-zA-Z0-9 ]", ""));
        }
        catch (IOException e){
            System.out.println("Boom, IOException!");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Could not load the specified problem: " + problemName);
            e.printStackTrace();
        }
    }

    static long timed(Problem p) throws IOException {
        long t0 = System.nanoTime();
        long result = p.solve();
        long t1 = System.nanoTime();
        long time = t1 - t0;
        System.out.println("Time: "+time+" ns  =  "+time/1_000_000+" ms");
        return result;
    }

}
/*

class Timer {
    long timed(Problem p) throws IOException {
        long t0 = System.nanoTime();
        long result = p.solve();
        long t1 = System.nanoTime();
        long time = t1 - t0;
        System.out.println("Time: "+time+" ns  =  "+time/1000+" ms");
        return result;
    }
}*/
