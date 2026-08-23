/**
 * Description: https://leetcode.com/problems/sum-game/
 */

public class SumGame {

	public boolean sumGame(String num) {
		char[] chars = num.toCharArray();
		int n = num.length(), sumL = 0, sumR = 0, cntL = 0, cntR = 0;
		for (int i = 0; i < n; i++) {
			if (i < (n >> 1)) {
				if (Character.isDigit(chars[i])) {
					sumL += (chars[i] - '0');
				} else {
					cntL++;
				}
			} else {
				if (Character.isDigit(chars[i])) {
					sumR += (chars[i] - '0');
				} else {
					cntR++;
				}
			}
		}

		if (((cntL + cntR) & 1) != 0) {
			return true;
		}
		if (cntL == cntR || cntL + cntR == 0) {
			return sumL != sumR;
		}
		return ((sumL - sumR) << 1) != 9 * (cntR - cntL);
	}
}
