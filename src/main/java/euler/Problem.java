package euler;

public abstract class Problem {

    public static Problem get(String name) {
        try {
            return (Problem) Class.forName(name).getConstructor().newInstance();
        } catch (Exception e) {throw new RuntimeException(e);}
    }

    abstract long solve();
}
