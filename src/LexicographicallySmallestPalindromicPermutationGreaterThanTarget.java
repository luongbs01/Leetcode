/**
 * Description: https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/
 */

public class LexicographicallySmallestPalindromicPermutationGreaterThanTarget {

	String ans;
	boolean found;
	int midChar;

	public String lexPalindromicPermutation(String s, String target) {
		int n = s.length(), cnt = 0;
		midChar = -1;
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if ((freq[i] & 1) != 0) {
				midChar = i;
				++cnt;
				if (cnt > 1)
					return "";
			}
			freq[i] = freq[i] >> 1;
		}
		found = false;
		StringBuilder str = new StringBuilder(n);
		backtrack(n / 2, str, target, freq, false);
		return found ? ans : "";
	}

	private void backtrack(int n, StringBuilder str, String target, int[] freq, boolean strictlyGreater) {
		if (found) {
			return;
		}
		if (str.length() == n) {
			String completePalindromic = completePalindromic(str, midChar).toString();
			if (completePalindromic.compareTo(target) > 0) {
				ans = completePalindromic;
				found = true;
			}
			return;
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

	private StringBuilder completePalindromic(StringBuilder left, int mid) {
		StringBuilder full = new StringBuilder(left);
		if (mid != -1) {
			full.append((char) (mid + 'a'));
		}
		StringBuilder reversed = new StringBuilder(left).reverse();
		return full.append(reversed);
	}
}
