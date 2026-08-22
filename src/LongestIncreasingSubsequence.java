import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

	// O(n^2)
	public int lengthOfLIS(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length]; // length of LIS ending at i
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	// O(nlog(n))
	public int lengthOfLISV2(int[] nums) {
		int n = nums.length;
		List<Integer> ans = new ArrayList<>(n);
		for (int num : nums) {
			if (ans.isEmpty() || ans.getLast() < num) {
				ans.add(num);
			} else {
				int l = 0, r = ans.size() - 1;
				while (l < r) {
					int mid = (l + r) >> 1;
					if (ans.get(mid) < num) {
						l = mid + 1;
					} else {
						r = mid;
					}
				}
				ans.set(l, num);
			}
		}
		return ans.size();
	}
}
