/**
 * Description: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
 */

public class SmallestPalindromicRearrangementI {

	public String smallestPalindrome(String s) {
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		StringBuilder ans = new StringBuilder(s.length());
		int mid = -1;
		for (int i = 0; i < 26; i++) {
			if ((freq[i] & 1) != 0) {
				mid = i;
			}
			ans.repeat(String.valueOf((char) (i + 'a')), Math.max(0, freq[i] >> 1));
			freq[i] >>= 1;
		}
		if (mid != -1) {
			ans.append((char) (mid + 'a'));
		}
		for (int i = 25; i >= 0; i--) {
			ans.repeat(String.valueOf((char) (i + 'a')), Math.max(0, freq[i]));
		}
		return ans.toString();
	}
}
