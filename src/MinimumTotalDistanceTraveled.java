import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-total-distance-traveled/
 */

public class MinimumTotalDistanceTraveled {

	public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
		List<Integer> factories = new ArrayList<>(robot.size() * factory.length);
		for (int[] i : factory) {
			for (int j = 0; j < i[1]; j++) {
				factories.add(i[0]);
			}
		}
		robot.sort(Comparator.naturalOrder());
		factories.sort(Comparator.naturalOrder());
		int n = robot.size(), m = factories.size();
		// dp[i][j]: minimum distance of first i robot and first j factory
		long[][] dp = new long[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], (long) 1e12);
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= m; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + Math.abs(robot.get(i - 1) - factories.get(j - 1)));
			}
		}
		return dp[n][m];
	}
}
