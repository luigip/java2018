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
            System.out.println(problemName + ": " + problem.solve());
        }
        catch (RuntimeException r) {
            System.out.println("Boom, runtime exception!");
            System.out.println(r);
        }
        catch (Exception e) {
            System.out.println("Could not load the specified problem: " + problemName);
            System.out.println(e);
        }
    }
}
