/**
 * Description: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
 */

public class MinimumDeletionsToMakeStringBalanced {

	public int minimumDeletions(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int[] cntA = new int[n + 1];
		int[] cntB = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			cntA[i] = cntA[i - 1] + (chars[i - 1] == 'a' ? 1 : 0);
			cntB[i] = cntB[i - 1] + (chars[i - 1] == 'b' ? 1 : 0);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			ans = Math.min(ans, cntB[i] + cntA[n] - cntA[i]);
		}
		return ans;
	}
}
