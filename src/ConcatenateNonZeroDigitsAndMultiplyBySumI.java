/**
 * Description: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
 */

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

	public long sumAndMultiply(int n) {
		long x = 0, d = 1;
		int sum = 0;
		while (n > 0) {
			if (n % 10 != 0) {
				x = d * (n % 10) + x;
				d *= 10;
				sum += (n % 10);
			}
			n /= 10;
		}
		return sum * x;
	}
}
