/**
 * Description: https://leetcode.com/problems/maximum-number-of-balloons/
 */

public class MaximumNumberOfBalloons {

	public int maxNumberOfBalloons(String text) {
		int[] cnt = new int[26];
		for (char c : text.toCharArray()) {
			cnt[c - 'a']++;
		}
		int ans = 10_000;
		ans = Math.min(ans, cnt['b' - 'a']);
		ans = Math.min(ans, cnt['a' - 'a']);
		ans = Math.min(ans, cnt['l' - 'a'] / 2);
		ans = Math.min(ans, cnt['o' - 'a'] / 2);
		ans = Math.min(ans, cnt['n' - 'a']);
		return ans;
	}
}
