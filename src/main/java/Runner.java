import java.io.IOException;
import static fint.Timer.timed;
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
            // Warm-up run - makes timing more valid. Otherwise it can be weirdly long, especially with Scala code
            long discarded_result = problem.solve();
            long result = timed(problem::solve);
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

}

