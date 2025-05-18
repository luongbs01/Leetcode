/**
 * Description: https://leetcode.com/problems/powx-n/description/
 */

public class Pow {
    public double myPow(double x, int n) {
        return myPow(x, (long) n);
    }

    public double myPow(double x, long n) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return myPow(1 / x, -n);
        double y = myPow(x, n / 2);
        if (n % 2 == 0) return y * y;
        else return x * y * y;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2.00000, -2147483648));
    }
}
