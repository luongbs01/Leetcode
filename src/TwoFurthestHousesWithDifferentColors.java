/**
 * Description: https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 */

public class TwoFurthestHousesWithDifferentColors {

	public int maxDistance(int[] colors) {
		int ans = 0, n = colors.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (colors[i] != colors[j]) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		return ans;
	}

	public int maxDistanceV2(int[] colors) {
		int n = colors.length;
		for (int i = 0; i < n; i++) {
			if (colors[0] != colors[n - 1 - i] || colors[n - 1] != colors[i]) {
				return n - 1 - i;
			}
		}
		return 0;
	}
}
