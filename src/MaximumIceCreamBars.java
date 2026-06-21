import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximum-ice-cream-bars/
 */

public class MaximumIceCreamBars {

	public int maxIceCream(int[] costs, int coins) {
		int maxCost = 0, ans = 0;
		for (int cost : costs) {
			maxCost = Math.max(maxCost, cost);
		}
		int[] cnt = new int[maxCost + 1];
		for (int cost : costs) {
			cnt[cost]++;
		}
		for (int i = 1; i <= maxCost && i <= coins; i++) {
			int j = Math.min(cnt[i], coins / i);
			ans += j;
			coins -= i * j;
		}
		return ans;
	}
}
