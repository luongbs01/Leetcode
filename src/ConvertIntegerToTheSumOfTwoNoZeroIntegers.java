/**
 * Description: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
 */

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (isValid(i) && isValid(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[0];
    }

    private boolean isValid(int i) {
        while (i != 0) {
            if (i % 10 == 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
