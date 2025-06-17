public class Formula {
    public static void main(String[] args) {
        // Upper limit of summation (can't calculate infinitely)
        // A higher limit -> more terms in sequence -> more accurate (up to a point)
        final int LIMIT = 100;

        System.out.println("True value:     e = " + Math.E);
        double calculated = formula(LIMIT);
        System.out.println("Formula result: e = " + calculated);

        double error = Math.abs(calculated - Math.E);
        if (error < 0.0001) {
            System.out.println("It works!");
        } else {
            System.out.println("It didn't work.");
        }
    }

    /** Returns n! = 1 * 2 * 3 * ... * n, for n >= 0 */
    public static int factorial(int n) {
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= i;
        }
        return product;
    }

    /** Returns the summation of 1 / 0! + 1 / 1! + 1 / 2! + ... + 1 / limit! */
    public static double formula(int limit) {
        double sum = 0.0;
        for (int n = 1; n <= limit; n++) {
            sum += 1 / factorial(n);
        }
        return sum;
    }
}
