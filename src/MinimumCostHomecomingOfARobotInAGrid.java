/**
 * Description: https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
 */

public class MinimumCostHomecomingOfARobotInAGrid {

	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
		int ans = 0, startX = startPos[0], startY = startPos[1], endX = homePos[0], endY = homePos[1];
		if (startX < endX) {
			for (int i = startX + 1; i <= endX; i++) {
				ans += rowCosts[i];
			}
		}
		if (startX > endX) {
			for (int i = startX - 1; i >= endX; i--) {
				ans += rowCosts[i];
			}
		}
		if (startY < endY) {
			for (int i = startY + 1; i <= endY; i++) {
				ans += colCosts[i];
			}
		}
		if (startY > endY) {
			for (int i = startY - 1; i >= endY; i--) {
				ans += colCosts[i];
			}
		}
		return ans;
	}
}
