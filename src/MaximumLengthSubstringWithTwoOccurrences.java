/**
 * Description: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/
 */

public class MaximumLengthSubstringWithTwoOccurrences {

	public int maximumLengthSubstring(String s) {
		int n = s.length(), ans = 1, l = 0;
		int[] cnt = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < n; i++) {
			cnt[chars[i] - 'a']++;
			while (cnt[chars[i] - 'a'] > 2) {
				cnt[chars[l] - 'a']--;
				l++;
			}
			ans = Math.max(ans, i - l + 1);
		}
		return ans;
	}
}
