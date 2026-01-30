import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/minimum-cost-to-convert-string-ii/description/
 */

public class MinimumCostToConvertStringII {

	public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
		HashMap<String, Integer> id = new HashMap<>();
		Set<Integer> len = new HashSet<>();
		int n = source.length(), sz = 0;
		int[][] minCost = new int[201][201];
		for (int i = 0; i < minCost.length; i++) {
			Arrays.fill(minCost[i], Integer.MAX_VALUE);
			minCost[i][i] = 0;
		}

		for (int i = 0; i < original.length; i++) {
			if (!id.containsKey(original[i])) {
				id.put(original[i], sz++);
				len.add(original[i].length());
			}
			if (!id.containsKey(changed[i])) {
				id.put(changed[i], sz++);
				len.add(changed[i].length());
			}
			int u = id.get(original[i]);
			int v = id.get(changed[i]);
			minCost[u][v] = Math.min(minCost[u][v], cost[i]);
		}

		// iterate on sz, NOT 201 to avoid TLE
		for (int k = 0; k < sz; k++) {
			for (int i = 0; i < sz; i++) {
				for (int j = 0; j < sz; j++) {
					if (minCost[i][k] < Integer.MAX_VALUE && minCost[k][j] < Integer.MAX_VALUE) {
						minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
					}
				}
			}
		}

		// dp[i]: minimum cost to change first i character of source to target
		long[] dp = new long[n + 1];
		Arrays.fill(dp, Long.MAX_VALUE >> 1);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (source.charAt(i - 1) == target.charAt(i - 1)) {
				dp[i] = Math.min(dp[i], dp[i - 1]);
			}
			for (int l : len) {
				if (i - l >= 0) {
					String s = source.substring(i - l, i);
					String t = target.substring(i - l, i);
					if (id.containsKey(s) && id.containsKey(t)) {
						int min = minCost[id.get(s)][id.get(t)];
						if (min < Integer.MAX_VALUE) {
							dp[i] = Math.min(dp[i], dp[i - l] + minCost[id.get(s)][id.get(t)]);
						}
					}
				}
			}
		}

		return dp[n] == Long.MAX_VALUE >> 1 ? -1 : dp[n];
	}
}
