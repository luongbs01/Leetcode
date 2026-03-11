/**
 * Description: https://leetcode.com/problems/complement-of-base-10-integer/description/
 */

public class ComplementOfBase10Integer {

	public int bitwiseComplement(int n) {
		if (n == 0) return 1;
		int i = 1;
		while (i <= n) {
			i <<= 1;
		}
		return n ^ (i - 1);
	}
}
