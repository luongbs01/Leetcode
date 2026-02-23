/**
 * Description: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
 */

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

	public boolean hasAllCodes(String s, int k) {
		int n = s.length();
		char[] chars = s.toCharArray();
		boolean[] found = new boolean[1 << k];
		int i = 0;
		for (int j = 0; j < n; j++) {
			i <<= 1;
			i ^= (chars[j] - '0');
			if (j >= k - 1) {
				i &= ~(1 << k);
				found[i] = true;
			}
		}
		for (boolean b : found) {
			if (!b) {
				return false;
			}
		}
		return true;
	}
}
