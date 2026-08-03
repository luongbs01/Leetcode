/**
 * Description: https://leetcode.com/problems/find-missing-elements/
 */

public class SmallestDivisibleDigitProductI {

	public int smallestNumber(int n, int t) {
		while (true) {
			int p = productOfDigit(n);
			if (p / t * t == p) {
				return n;
			}
			n++;
		}
	}

	private int productOfDigit(int n) {
		int p = 1;
		while (n > 0) {
			p *= n % 10;
			n /= 10;
		}
		return p;
	}
}
