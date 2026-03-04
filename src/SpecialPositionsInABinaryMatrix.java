/**
 * Description: https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/
 */

public class SpecialPositionsInABinaryMatrix {

	public int numSpecial(int[][] mat) {
		int m = mat.length, n = mat[0].length, ans = 0;
		int[] rowCnt = new int[m], colCnt = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					rowCnt[i]++;
					colCnt[j]++;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1 && rowCnt[i] == 1 && colCnt[j] == 1) {
					ans++;
				}
			}
		}
		return ans;
	}
}
