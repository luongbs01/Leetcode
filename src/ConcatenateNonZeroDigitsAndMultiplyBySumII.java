import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
 */

public class ConcatenateNonZeroDigitsAndMultiplyBySumII {

	public int[] sumAndMultiply(String s, int[][] queries) {
		int n = s.length(), m = queries.length, mod = 1_000_000_007;
		char[] chars = s.toCharArray();
		long[] preX = new long[n + 1];
		int[] preSum = new int[n + 1];
		int[] len = new int[n + 1];
		long[] pow10 = new long[n + 1];
		pow10[0] = 1;
		for (int i = 1; i <= n; i++) {
			preSum[i] = preSum[i - 1] + (chars[i - 1] - '0');
			pow10[i] = (pow10[i - 1] * 10) % mod;
			if (chars[i - 1] != '0') {
				preX[i] = (preX[i - 1] * 10 + (chars[i - 1] - '0')) % mod;
				len[i] = len[i - 1] + 1;
			} else {
				preX[i] = preX[i - 1];
				len[i] = len[i - 1];
			}
		}

		System.out.println("len:" + Arrays.toString(len));
		System.out.println("preSum:" + Arrays.toString(preSum));
		System.out.println("preX:" + Arrays.toString(preX));
		System.out.println("pow10:" + Arrays.toString(pow10));

		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			int l = queries[i][0], r = queries[i][1] + 1;
			long x = (preX[r] - (preX[l] * pow10[len[r] - len[l]]) % mod + mod) % mod;
			int sum = preSum[r] - preSum[l];
			ans[i] = (int) ((x * sum) % mod);
		}
		return ans;
	}
}
