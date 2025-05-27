/**
 * Description: https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/
 */

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long countZero1 = 0, countZero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                countZero1++;
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                countZero2++;
            }
        }
        if ((countZero1 == 0 && sum2 + countZero2 > sum1)
                || (countZero2 == 0 && sum1 + countZero1 > sum2)) {
            return -1;
        }
        return Math.max(sum1 + countZero1, sum2 + countZero2);
    }
}
