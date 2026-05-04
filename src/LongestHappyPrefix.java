/**
 * Description: https://leetcode.com/problems/longest-happy-prefix/
 */

public class LongestHappyPrefix {

	public String longestPrefix(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int[] lps = new int[n];
		for (int i = 1; i < n; i++) {
			int j = lps[i - 1];
			while (j > 0 && chars[i] != chars[j]) {
				j = lps[j - 1];
			}
			if (chars[i] == chars[j]) {
				j++;
			}
			lps[i] = j;
		}
		return s.substring(0, lps[n - 1]);
	}
}
