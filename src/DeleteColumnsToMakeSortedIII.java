import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/delete-columns-to-make-sorted-iii/
 */

public class DeleteColumnsToMakeSortedIII {

	public int minDeletionSize(String[] strs) {
		int n = strs.length, m = strs[0].length(), ans = m;
		int[] dp = new int[m]; // dp[i]: max number of column, ending at i
		Arrays.fill(dp, 1);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < i; j++) {
				boolean valid = true;
				for (String str : strs) {
					if (str.charAt(j) > str.charAt(i)) {
						valid = false;
						break;
					}
				}
				if (valid) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.min(ans, m - dp[i]);
		}
		return ans;
	}
}
