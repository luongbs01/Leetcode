/**
 * Description: https://leetcode.com/problems/last-substring-in-lexicographical-order/
 */

public class LastSubstringInLexicographicalOrder {

	public String lastSubstring(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int lastIndex = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (chars[i] > chars[lastIndex]) {
				lastIndex = i;
			} else if (chars[i] == chars[lastIndex]) {
				boolean larger = true;
				for (int j = 1; i + j < lastIndex && lastIndex + j < n; j++) {
					if (chars[i + j] > chars[lastIndex + j]) {
						break;
					} else if (chars[i + j] < chars[lastIndex + j]) {
						larger = false;
						break;
					}
				}
				if (larger) {
					lastIndex = i;
				}
			}
		}
		return s.substring(lastIndex);
	}
}
