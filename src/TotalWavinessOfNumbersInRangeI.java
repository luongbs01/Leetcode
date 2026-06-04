import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/
 */

public class TotalWavinessOfNumbersInRangeI {

	String str;
	int n;
	int[][][][][][] memo;

	public int totalWaviness(int num1, int num2) {
		return totalWaviness(num2) - totalWaviness(num1 - 1);
	}

	public int totalWaviness(int num) {
		if (num < 100) {
			return 0;
		}
		str = String.valueOf(num);
		n = str.length();
		memo = new int[n][2][11][11][n + 1][n];
		for (int[][][][][] i : memo) {
			for (int[][][][] j : i) {
				for (int[][][] k : j) {
					for (int[][] l : k) {
						for (int[] m : l) {
							Arrays.fill(m, -1);
						}
					}
				}
			}
		}
		return dp(0, true, 10, 10, n, 0);
	}

	private int dp(int pos, boolean tight, int secondLastDigit, int lastDigit, int startPos, int cnt) {
		if (pos == n) {
			return cnt;
		}
		int tightIndex = tight ? 1 : 0;
		if (pos >= startPos + 2 && memo[pos][tightIndex][secondLastDigit][lastDigit][startPos][cnt] != -1) {
			return memo[pos][tightIndex][secondLastDigit][lastDigit][startPos][cnt];
		}

		int total = 0;
		int limit = tight ? str.charAt(pos) - '0' : 9;
		for (int currDigit = 0; currDigit <= limit; currDigit++) {
			boolean nextTight = tight && currDigit == limit;
			int nextStartPos = startPos != n ? startPos : currDigit != 0 ? pos : n;
			int inc = pos >= startPos + 2
				&& ((lastDigit > currDigit && lastDigit > secondLastDigit) || (lastDigit < currDigit && lastDigit < secondLastDigit)) ? 1 : 0;
			total += dp(pos + 1, nextTight, lastDigit, currDigit, nextStartPos, cnt + inc);
		}
		memo[pos][tightIndex][secondLastDigit][lastDigit][startPos][cnt] = total;
		return total;
	}
}
