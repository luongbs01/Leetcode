import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/number-of-digit-one/
 */

public class NumberOfDigitOne {

	int[][][] memo;
	String str;
	int length;

	public int countDigitOne(int n) {
		str = String.valueOf(n);
		length = str.length();
		memo = new int[length][2][length];
		for (int[][] i : memo) {
			for (int[] j : i) {
				Arrays.fill(j, -1);
			}
		}
		return dp(0, true, 0);
	}

	private int dp(int pos, boolean tight, int cnt) {
		if (pos == length) {
			return cnt;
		}
		if (memo[pos][tight ? 1 : 0][cnt] != -1) {
			return memo[pos][tight ? 1 : 0][cnt];
		}

		int total = 0;
		int limit = tight ? str.charAt(pos) - '0' : 9;
		for (int digit = 0; digit <= limit; digit++) {
			total += dp(pos + 1, tight && digit == limit, digit == 1 ? (cnt + 1) : cnt);
		}
		memo[pos][tight ? 1 : 0][cnt] = total;
		return total;
	}
}
