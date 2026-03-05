/**
 * Description: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */

public class MinimumChangesToMakeAlternatingBinaryString {

	public int minOperations(String s) {
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((i & 1) != 0) {
				if (s.charAt(i) == '0') {
					cnt1++;
				} else {
					cnt2++;
				}
			} else {
				if (s.charAt(i) == '0') {
					cnt2++;
				} else {
					cnt1++;
				}
			}
		}
		return Math.min(cnt1, cnt2);
	}
}
