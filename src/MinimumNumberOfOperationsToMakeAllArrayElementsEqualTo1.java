/**
 * Description: https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
 */

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    public int minOperations(int[] nums) {
        int n = nums.length, ones = 0;
        for (int i : nums) {
            if (i == 1)
                ones++;
        }
        if (ones > 0)
            return n - ones;
        for (int dist = 1; dist < n; dist++) {
            for (int i = 0; i < n - dist; i++) {
                int gcd = nums[i];
                for (int j = i + 1; j <= i + dist; j++) {
                    gcd = gcd(gcd, nums[j]);
                }
                if (gcd == 1)
                    return dist + n - 1;
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        while (a * b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        return Math.max(a, b);
    }
}
