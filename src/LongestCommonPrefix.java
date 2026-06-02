/**
 * Description: https://leetcode.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		int cnt;
		for (cnt = 0; cnt < strs[0].length(); cnt++) {
			boolean common = true;
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= cnt || strs[j].charAt(cnt) != strs[0].charAt(cnt)) {
					common = false;
					break;
				}
			}
			if (!common) {
				break;
			}
		}
		return strs[0].substring(0, cnt);
	}
}
