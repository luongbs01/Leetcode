import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/
 */

public class SumOfGCDOfFormedPairs {

	public long gcdSum(int[] nums) {
		int n = nums.length, mx = Integer.MIN_VALUE;
		int[] prefixGcd = new int[n];
		for (int i = 0; i < n; i++) {
			mx = Math.max(mx, nums[i]);
			prefixGcd[i] = gcd(nums[i], mx);
		}
		Arrays.sort(prefixGcd);
		long ans = 0;
		for (int i = 0; i < n / 2; i++) {
			ans += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
		}
		return ans;
	}

	private int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return a + b;
		if (a == b)
			return a;
		if (a > b)
			return gcd(a % b, b);
		return gcd(a, b % a);
	}
}
