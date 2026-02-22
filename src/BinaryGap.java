/**
 * Description: https://leetcode.com/problems/binary-gap/
 */

public class BinaryGap {

	public int binaryGap(int n) {
		int ans = 0, prev = -1, curr = -1;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				prev = curr;
				curr = i;
			}
			if (prev >= 0) {
				ans = Math.max(ans, curr - prev);
			}
		}
		return ans;
	}
}
