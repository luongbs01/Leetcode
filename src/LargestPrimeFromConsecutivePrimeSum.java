import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/largest-prime-from-consecutive-prime-sum/description/
 */

public class LargestPrimeFromConsecutivePrimeSum {

	public int largestPrime(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				for (int j = 2; j <= n / i; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		int sum = 0, ans = 0;
		for (int i = 2; sum + i <= n; i++) {
			if (isPrime[i]) {
				sum += i;
				if (isPrime[sum]) {
					ans = sum;
				}
			}
		}
		return ans;
	}
}
