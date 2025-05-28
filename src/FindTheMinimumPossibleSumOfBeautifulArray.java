/**
 * Description: https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/
 */

public class FindTheMinimumPossibleSumOfBeautifulArray {

    public int minimumPossibleSum(int n, int target) {
        long mod = 1000000007;
        long k = Math.min(n, target >> 1);
        long sum1 = k * (k + 1) / 2;
        long j = n - k;
        long sum2 = j * target + j * (j - 1) / 2;
        return (int) ((sum1 + sum2) % mod);
    }
}
