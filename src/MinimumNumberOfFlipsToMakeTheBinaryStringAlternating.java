/**
 * Description: https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
 */

public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {

	public int minFlips(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();

		// minPre[0][i] = flips needed to make s[0..i-1] alternating starting with '0'
		// minPre[1][i] = flips needed to make s[0..i-1] alternating starting with '1'
		int[][] minPre = new int[2][n + 1];

		// minSuf[0][i] = flips needed to make s[i .. n-1] alternating ending with '0'
		// minSuf[1][i] = flips needed to make s[i .. n-1] alternating ending with '1'
		int[][] minSuf = new int[2][n + 1];
		for (int i = 0; i < n; i++) {
			if ((i & 1) == 0) { // index 0, 2, 4, 6..
				if (chars[i] == '0') {
					minPre[0][i + 1] = minPre[0][i];
					minPre[1][i + 1] = 1 + minPre[1][i];
				} else {
					minPre[0][i + 1] = 1 + minPre[0][i];
					minPre[1][i + 1] = minPre[1][i];
				}
			} else { // index 1, 3, 5, 7..
				if (chars[i] == '0') {
					minPre[0][i + 1] = 1 + minPre[0][i];
					minPre[1][i + 1] = minPre[1][i];
				} else {
					minPre[0][i + 1] = minPre[0][i];
					minPre[1][i + 1] = 1 + minPre[1][i];
				}
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (((n - 1 - i) & 1) == 0) { // index n-1, n-3, n-5,..
				if (chars[i] == '0') {
					minSuf[0][i] = minSuf[0][i + 1];
					minSuf[1][i] = 1 + minSuf[1][i + 1];
				} else {
					minSuf[0][i] = 1 + minSuf[0][i + 1];
					minSuf[1][i] = minSuf[1][i + 1];
				}
			} else { // index n-2, n-4, n-6,..
				if (chars[i] == '0') {
					minSuf[0][i] = 1 + minSuf[0][i + 1];
					minSuf[1][i] = minSuf[1][i + 1];
				} else {
					minSuf[0][i] = minSuf[0][i + 1];
					minSuf[1][i] = 1 + minSuf[1][i + 1];
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			ans = Math.min(ans, Math.min(minSuf[1][i] + minPre[0][i], minSuf[0][i] + minPre[1][i]));
		}
		return ans;
	}
}
