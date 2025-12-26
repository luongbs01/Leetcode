/**
 * Description: https://leetcode.com/problems/minimum-penalty-for-a-shop/
 */

public class MinimumPenaltyForAShop {

	public int bestClosingTime(String customers) {
		int n = customers.length(), ans = -1, min = Integer.MAX_VALUE, cnt = 0;
		char[] chars = customers.toCharArray();
		int[] closePenalty = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			closePenalty[i] = closePenalty[i + 1] + (chars[i] == 'Y' ? 1 : 0);
		}
		for (int i = 0; i <= n; i++) {
			if (min > cnt + closePenalty[i]) {
				min = cnt + closePenalty[i];
				ans = i;
			}
			cnt += i < n && chars[i] == 'N' ? 1 : 0;
		}
		return ans;
	}
}
