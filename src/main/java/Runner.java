import java.io.IOException;
import static fint.Timer.timed;
public class Runner {

    //* Whether we are doing a performance test. This may take longer since we run it twice.
    private static boolean checkTime = false;

    public static void main(String[] args) {
        // args: [class name][number of timing runs, e.g. ttt = 3 runs]


        if (args.length == 0) {
            System.out.println("No problem specified. Class name of problem needs to be passed as an argument.\n" +
                    "Try editing the run configuration.");
            return;
        }
        String problemName = args[0];
        try {
            Problem problem = (Problem) Class.forName(problemName).getConstructor().newInstance();
            long result;
            if(checkTime || (args.length >= 2 && args[1].contains("t")))
                result = timed(problem::solve, args[1].length());
                else result = problem.solve();
            System.out.println(problemName + ": " + result);
        }
        catch (RuntimeException r) {
            System.out.println("Boom, runtime exception!");
            System.out.println(r.toString().replaceAll("[^a-zA-Z0-9 ]", ""));
            r.printStackTrace();
        }
        catch (IOException e){
            System.out.println("Boom, IOException!");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Could not load the specified problem: " + problemName);
            e.printStackTrace();
        }
        finally {
//            Toolkit.getDefaultToolkit().beep();
        }
    }

}

