/**
 * Description: https://leetcode.com/problems/count-the-number-of-special-characters-i/description/
 */

public class CountTheNumberOfSpecialCharactersI {

	public int numberOfSpecialChars(String word) {
		boolean[] lower = new boolean[26];
		boolean[] upper = new boolean[26];
		for (char c : word.toCharArray()) {
			if (c <= 'Z') {
				upper[c - 'A'] = true;
			} else {
				lower[c- 'a'] = true;
			}
		}
		int ans = 0;
		for (int i = 0; i < 26; i++) {
			if (upper[i] && lower[i]) {
				ans++;
			}
		}
		return ans;
	}
}
