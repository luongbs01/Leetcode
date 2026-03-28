/**
 * Description: https://leetcode.com/problems/find-the-string-with-lcp/description/
 */

public class FindTheStringWithLCP {

	public String findTheString(int[][] lcp) {
		int n = lcp.length;
		char[] ans = new char[n];
		char curr = 'a';
		ans[0] = curr;
		for (int i = 0; i < n; i++) {
			if (ans[i] == 0) {
				curr++;
				if (curr > 'z') {
					return "";
				}
				ans[i] = curr;
			}
			for (int j = i + 1; j < n; j++) {
				if (ans[j] == 0 && lcp[i][j] > 0) {
					ans[j] = curr;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (lcp[i][j] != lcp[j][i]) {
					return "";
				}
				if (ans[i] != ans[j] && lcp[i][j] != 0) {
					return "";
				}
				if ((i == n - 1 || j == n - 1) && ans[i] == ans[j] && lcp[i][j] != 1) {
					return "";
				}
				if (i < n - 1 && j < n - 1 && ans[i] == ans[j] && (lcp[i][j] != lcp[i + 1][j + 1] + 1)) {
					return "";
				}
			}
		}
		return new String(ans);
	}
}
