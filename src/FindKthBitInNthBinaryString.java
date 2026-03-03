/**
 * Description: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/
 */

public class FindKthBitInNthBinaryString {

	public char findKthBit(int n, int k) {
		if (k == 1)
			return '0';
		if ((k & (k - 1)) == 0)
			return '1';
		int i = 2;
		while (i < k) {
			i <<= 1;
		}
		return (char) ('1' - findKthBit(n, i - k) + '0');
	}
}
