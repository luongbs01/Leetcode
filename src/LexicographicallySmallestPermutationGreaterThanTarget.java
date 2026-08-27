/**
 * Description: https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/
 */

public class LexicographicallySmallestPermutationGreaterThanTarget {

	boolean found;
	String ans;

	public String lexGreaterPermutation(String s, String target) {
		int n = s.length();
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		found = false;
		StringBuilder str = new StringBuilder(n);
		backtrack(n, str, target, freq, false);
		return found ? ans : "";
	}

	private void backtrack(int n, StringBuilder str, String target, int[] freq, boolean strictlyGreater) {
		if (found) {
			return;
		}
		if (str.length() == n) {
			if (str.toString().compareTo(target) > 0) {
				ans = str.toString();
				found = true;
				return;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (!found && freq[i] > 0 && (strictlyGreater || i >= (target.charAt(str.length()) - 'a'))) {
				str.append((char) (i + 'a'));
				freq[i]--;
				backtrack(n, str, target, freq, strictlyGreater || i > (target.charAt(str.length() - 1) - 'a'));
				str.deleteCharAt(str.length() - 1);
				freq[i]++;
			}
		}
	}
}
