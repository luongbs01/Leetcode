/**
 * Description: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 */

public class ConcatenationOfConsecutiveBinaryNumbers {

	// 393ms
	public int concatenatedBinaryV1(int n) {
		long ans = 1, mod = 1_000_000_007;
		for (int i = 2; i <= n; i++) {
			int j = 31;
			while ((i & (1 << j)) == 0) {
				j--;
			}
			while (j >= 0) {
				ans <<= 1;
				if ((i & (1 << j)) != 0) {
					ans |= 1;
				}
				ans %= mod;
				j--;
			}
		}
		return (int) (ans % mod);
	}

	// 24ms
	public int concatenatedBinaryV2(int n) {
		long ans = 1, mod = 1_000_000_007, cnt = 1;
		for (int i = 2; i <= n; i++) {
			if ((i & (i - 1)) == 0)
				cnt++;
			ans = (ans << cnt) | i;
			ans %= mod;
		}

		return (int) ans;
	}
}
