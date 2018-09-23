abstract class Problem {

    public static void main(String[] args) throws Exception {

        String defaultProblem = "Euler_002";

        // if there is a problem name passed in the run configuration, that takes precedence.
        String problemName = (args.length > 0) ? args[0] : defaultProblem;
        Problem problem = (Problem) Class.forName(problemName).getConstructor().newInstance();
        System.out.println(problemName + ": " + problem.solve());
    }

    abstract long solve();
}
