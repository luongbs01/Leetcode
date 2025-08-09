public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n <= 0 || (n & 1) != 0)
            return false;
        return isPowerOfTwo(n >> 1);
    }

    public boolean isPowerOfTwoV2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
