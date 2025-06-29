import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 */

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        long[] mod = new long[n];
        mod[0] = 1;
        for (int i = 1; i < n; i++) {
            mod[i] = (mod[i - 1] * 2) % MOD;
        }
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        long ans = 0;
        while (l < r) {
            while (l < r && nums[l] + nums[r] > target) {
                r--;
            }
            if (nums[l] + nums[r] <= target) {
                ans += mod[r - l]; // number of valid subsequence starting at l
                ans %= MOD;
            }
            l++;
        }
        return (int) ans;
    }
}
