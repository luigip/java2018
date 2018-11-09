package euler;

import static fint.Timer.TimerLong;

public class Runner {

    //* Whether we are doing a performance test by default. If args[1] contains 't' then it is timed anyway
    private static boolean checkTime = false;

    public static void main(String[] args) {
        // args: [class name][number of timing runs, e.g. ttt = 3 runs]

        if (args.length == 0) {
            System.out.println("No problem specified. Class name of problem needs to be passed as an argument.\n" +
                    "Try editing the run configuration.");
            return;
        }
        String problemName = args[0];
        // Can just specify number instead of full package + Euler_ ...
        if(problemName.matches("\\d+")) problemName =
                Runner.class.getPackage().getName() + ".Euler_" + String.format("%03d",Integer.valueOf(problemName));
        final String className = problemName;
        try {

            long result;
            if(checkTime || (args.length >= 2 && args[1].contains("t"))){
                // We get the Problem instance within the lambda so that all set-up is timed
                result = TimerLong.timed(() -> Problem.get(className).solve(), args[1].length());
            }
                else result = Problem.get(className).solve();
            System.out.println(className + ": " + result);
        }
        catch (RuntimeException r) {
            System.out.println("Boom, runtime exception!");
//            Include the following line if the exception isn't printing properly (something to do with newline symbols)
//            System.out.println(r.toString().replaceAll("[^a-zA-Z0-9 ]", ""));
            r.printStackTrace();
        }
//        Commented out because we should handle IOExceptions in situ since it lets us use "Supplier" in timer
//        catch (IOException e){
//            System.out.println("Boom, IOException!");
//            e.printStackTrace();
//        }
        catch (Exception e) {
            System.out.println("Could not load the specified problem: " + problemName);
            e.printStackTrace();
        }
    }

}

