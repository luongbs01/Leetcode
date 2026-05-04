/**
 * Description: https://leetcode.com/problems/rotate-string/
 */

public class RotateString {

	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && s.repeat(2).contains(goal);
	}

	// KMP
	public boolean rotateStringV2(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		s = goal + s + s;
		int m = goal.length(), n = s.length();
		int[] lps = new int[n];
		for (int i = 1; i < n; i++) {
			int j = lps[i - 1];
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = lps[j - 1];
			}
			if (s.charAt(i) == s.charAt(j)) {
				j++;
			}
			lps[i] = j;
		}
		for (int i = m; i < n; i++) {
			if (lps[i] == m) {
				return true;
			}
		}
		return false;
	}
}
