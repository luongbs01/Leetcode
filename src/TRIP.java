import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: https://oj.vnoi.info/problem/lem3
 */

public class TRIP {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] grid = new int[n][n];
		int[][] dp = new int[1 << n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			// NOTE: ((1 << n) - 1) != (1 << n - 1)
			ans = Math.min(ans, minCost(n, grid, (1 << n) - 1, i, dp));
		}
		System.out.println(ans);
	}

	public static int minCost(int n, int[][] grid, int visited, int lastDest, int[][] dp) {
		int oneBits = Integer.bitCount(visited);
		if (oneBits == 1)
			return 0;
		if (dp[visited][lastDest] != -1)
			return dp[visited][lastDest];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (i != lastDest && (visited & (1 << i)) != 0) {
				min = Math.min(min, minCost(n, grid, visited & (~(1 << lastDest)), i, dp) + grid[i][lastDest]);
			}
		}
		return dp[visited][lastDest] = min;
	}
}
