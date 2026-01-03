/**
 * Description: https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
 */

public class NumberOfWaysToPaintNx3Grid {
	public int numOfWays(int n) {
		long combinationOf3 = 6, combinationOf2 = 6, mod = 1_000_000_007;
		for (int i = 1; i < n; i++) {
			long nextRowCombinationOf3 = (combinationOf3 * 2 + combinationOf2 * 2) % mod;
			long nextRowCombinationOf2 = (combinationOf3 * 2 + combinationOf2 * 3) % mod;
			combinationOf3 = nextRowCombinationOf3;
			combinationOf2 = nextRowCombinationOf2;
		}
		return (int) ((combinationOf3 + combinationOf2) % mod);
	}
}
