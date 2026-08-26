/**
 * Description: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 */

public class ShortestAndLexicographicallySmallestBeautifulString {

	public String shortestBeautifulSubstring(String s, int k) {
		int n = s.length(), l = 0, cnt = 0, min = 101;
		String ans = String.valueOf('1').repeat(k);
		for (int r = 0; r < n; r++) {
			if (s.charAt(r) == '1') {
				cnt++;
			}
			while (l < n && cnt >= k) {
				min = Math.min(min, r - l + 1);
				if (s.charAt(l) == '1') {
					cnt--;
				}
				l++;
			}
		}
		if (min == 101)
			return "";
		cnt = 0;
		for (int i = 0; i < min; i++) {
			if (s.charAt(i) == '1') {
				cnt++;
			}
		}
		for (int i = min; i <= n; i++) {
			String substring = s.substring(i - min, i);
			if (cnt == k && ans.compareTo(substring) > 0) {
				ans = substring;
			}
			if (i < n && s.charAt(i) == '1') {
				cnt++;
			}
			if (i < n && s.charAt(i - min) == '1') {
				cnt--;
			}
		}
		return ans;
	}
}
