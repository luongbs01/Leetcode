/**
 * Description: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/
 */

public class CheckDivisibilityByDigitSumAndProduct {

	public boolean checkDivisibility(int n) {
		int i = n, sum = 0, p = 1;
		while (i != 0) {
			sum += i % 10;
			p *= i % 10;
			i /= 10;
		}
		return n % (sum + p) == 0;
	}
}
