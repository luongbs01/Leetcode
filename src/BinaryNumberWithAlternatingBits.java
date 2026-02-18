/**
 * Description: https://leetcode.com/problems/binary-number-with-alternating-bits/
 */

public class BinaryNumberWithAlternatingBits {

	public boolean hasAlternatingBits(int n) {
		int bit = n & 1;
		while (n != 0) {
			n >>= 1;
			if (bit == (n & 1)) {
				return false;
			}
			bit = n & 1;
		}
		return true;
	}
}
