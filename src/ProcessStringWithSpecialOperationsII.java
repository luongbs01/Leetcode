/**
 * Description: https://leetcode.com/problems/process-string-with-special-operations-ii/
 */

public class ProcessStringWithSpecialOperationsII {

	public char processStr(String s, long k) {
		char[] chars = s.toCharArray();
		long length = 0;
		for (char c : chars) {
			if (c == '*') {
				if (length > 0) {
					length--;
				}
			} else if (c == '#') {
				length <<= 1;
			} else if (c == '%') {
			} else {
				length++;
			}
		}

		if (k >= length) {
			return '.';
		}
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == '*') {
				length++;
			} else if (chars[i] == '#') {
				length >>= 1;
				if (k >= length) {
					k -= length;
				}
			} else if (chars[i] == '%') {
				k = length - 1 - k;
			} else {
				if (k == length - 1) {
					return chars[i];
				}
				length--;
			}
		}
		return '.';
	}
}
