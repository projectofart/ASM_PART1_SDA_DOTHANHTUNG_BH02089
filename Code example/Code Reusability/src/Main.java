class MathUtils {
    // Static method to calculate factorial
    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative");
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Static method to find the greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        // Reuse utility methods
        System.out.println("Factorial of 5: " + MathUtils.factorial(5));
        System.out.println("GCD of 48 and 18: " + MathUtils.gcd(48, 18));
    }
}
