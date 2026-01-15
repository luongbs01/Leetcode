import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/
 */

public class MaximizeAreaOfSquareHoleInGrid {

	public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
		Arrays.sort(hBars);
		Arrays.sort(vBars);
		int maxH = maxConsecutive(hBars);
		int maxV = maxConsecutive(vBars);
		int min = Math.min(maxH, maxV);
		return (min + 1) * (min + 1);
	}

	private int maxConsecutive(int[] bars) {
		int n = bars.length, ans = 1, count = 1;
		for (int i = 1; i < n; i++) {
			if (bars[i] == bars[i - 1] + 1) {
				count++;
				ans = Math.max(ans, count);
			} else {
				count = 1;
			}
		}
		return ans;
	}
}
