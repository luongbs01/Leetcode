/**
 * Description: https://leetcode.com/problems/reverse-string/
 */

public class ReverseString {

	public void reverseString(char[] s) {
		int n = s.length;
		for (int i = 0; (i << 1) < n; i++) {
			char t = s[i];
			s[i] = s[n - 1 - i];
			s[n - 1 - i] = t;
		}
	}
}
