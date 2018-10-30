import java.math.BigInteger;

public class Euler_016 extends Problem {
    @Override
    long solve() {
        int exponent = 1000;
        BigInteger power = BigInteger.valueOf(2).pow(exponent);
        return power.toString().codePoints().map(Character::getNumericValue).sum();
    }
}
