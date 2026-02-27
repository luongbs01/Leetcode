/**
 * Description: https://leetcode.com/problems/length-of-last-word/
 */

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int ans = 0, i = s.length() - 1;
		while (s.charAt(i) == ' ') {
			i--;
		}
		while (i >= 0 && s.charAt(i) != ' ') {
			ans++;
			i--;
		}
		return ans;
	}
}
