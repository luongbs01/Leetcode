import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/longest-balanced-subarray-i/
 */

public class LongestBalancedSubstringI {

	public int longestBalanced(String s) {
		int n = s.length(), ans = 1;
		char[] chars = s.toCharArray();
		int[] cnt = new int[26];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cnt, 0);
			for (int j = i; j < n; j++) {
				cnt[chars[j] - 'a']++;
				boolean flag = true;
				for (int k : cnt) {
					if (k != 0 && k != cnt[chars[j] - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}
		return ans;
	}
}
