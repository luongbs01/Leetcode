/**
 * Description: https://leetcode.com/problems/number-complement/
 */

public class NumberComplement {

	public int findComplement(int num) {
		int i = 1;
		while (i < num) {
			i = (i << 1) | 1;
		}
		return num ^ i;
	}
}
