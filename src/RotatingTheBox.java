/**
 * Description: https://leetcode.com/problems/rotating-the-box/description/
 */

public class RotatingTheBox {

	public char[][] rotateTheBox(char[][] boxGrid) {
		int m = boxGrid.length, n = boxGrid[0].length;
		char[][] ans = new char[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans[j][m - i - 1] = boxGrid[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			int pos = n - 1, stone = n - 1;
			while (stone >= 0) {
				if (ans[stone][i] == '*') {
					pos = stone - 1;
				} else if (ans[stone][i] == '#') {
					ans[stone][i] = '.';
					ans[pos][i] = '#';
					pos--;
				}
				stone--;
			}
		}
		return ans;
	}
}
