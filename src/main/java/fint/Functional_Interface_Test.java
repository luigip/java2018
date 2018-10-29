package fint;

public class Functional_Interface_Test {

    public static void main(String[] args) {

        // Functional interface is used to enable the use of lambda expression syntax to create new instance

        Functional_Interface_Test_Interface f =
                // block lamba expression
                str -> {
                    int[] arr = str.chars().map(Character::toUpperCase).toArray();
                    return  new String(arr,0, arr.length);
                };

        System.out.println(f.process("abcDEFghi"));

        // using an inline lambda where the type is expected
        System.out.println(testMethod(s -> "*** " + s));
        // same except block lambda expression
        System.out.println(testMethod(s -> {
            String suffix = " XXX";
            return s + suffix;
        }));
    }

    private static String testMethod(Functional_Interface_Test_Interface fiti_impl) {
        return fiti_impl.process("Test String");
    }



}
