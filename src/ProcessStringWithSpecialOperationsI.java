/**
 * Description: https://leetcode.com/problems/process-string-with-special-operations-i/
 */

public class ProcessStringWithSpecialOperationsI {

	public String processStr(String s) {
		StringBuilder ans = new StringBuilder(s.length());
		for (char c : s.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				ans.append(c);
			} else if (c == '*' && !ans.isEmpty()) {
				ans.deleteCharAt(ans.length() - 1);
			} else if (c == '#') {
				ans.repeat(ans, 1);
			} else if (c == '%') {
				ans.reverse();
			}
		}
		return ans.toString();
	}
}
