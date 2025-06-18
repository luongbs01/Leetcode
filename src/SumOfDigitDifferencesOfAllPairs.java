/**
 * Description: https://leetcode.com/problems/sum-of-digit-differences-of-all-pairs/description/
 */

public class SumOfDigitDifferencesOfAllPairs {

    public long sumDigitDifferences(int[] nums) {
        int n = String.valueOf(nums[0]).length();
        long[][] cnt = new long[n][10];
        for (int num : nums) {
            int i = num;
            for (int j = 0; j < n; j++) {
                cnt[j][i % 10]++;
                i /= 10;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 10; k++) {
                    ans += cnt[i][j] * cnt[i][k];
                }
            }
        }
        return ans;
    }
}
