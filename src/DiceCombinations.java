import java.util.Scanner;

/**
 * Description: https://cses.fi/problemset/task/1633
 */

public class DiceCombinations {

	public static long[] dp = new long[1_000_001];
	public static final int MOD = 1_000_000_007;

	static {
		dp[0] = 1;
		for (int i = 1; i <= 1_000_000; i++) {
			for (int j = Math.max(0, i - 6); j < i; j++) {
				dp[i] += dp[j];
			}
			dp[i] %= MOD;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.print(dp[n]);
	}
}
