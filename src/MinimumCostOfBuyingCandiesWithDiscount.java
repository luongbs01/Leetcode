import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
 */

public class MinimumCostOfBuyingCandiesWithDiscount {

	public int minimumCost(int[] cost) {
		Arrays.sort(cost);
		int ans = 0, cnt = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			if (cnt < 2) {
				ans += cost[i];
				cnt++;
			} else {
				cnt = 0;
			}
		}
		return ans;
	}
}
