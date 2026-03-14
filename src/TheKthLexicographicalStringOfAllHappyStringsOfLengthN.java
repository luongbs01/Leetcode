/**
 * Description: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 */

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

	String ans;
	int count;

	public String getHappyString(int n, int k) {
		if (k > 3 * (1 << (n - 1))) {
			return "";
		}
		backtrack(new StringBuilder(n), n, k);
		return ans;
	}

	private void backtrack(StringBuilder sb, int n, int k) {
		if (sb.length() == n) {
			count++;
			if (count == k) {
				ans = sb.toString();
			}
			return;
		}
		for (char c = 'a'; c <= 'c'; c++) {
			if (sb.isEmpty() || sb.charAt(sb.length() - 1) != c) {
				sb.append(c);
				backtrack(sb, n, k);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
