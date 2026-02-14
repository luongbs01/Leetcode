/**
 * Description: https://leetcode.com/problems/champagne-tower/description/
 */

public class ChampagneTower {

	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] glasses = new double[100][100];
		glasses[0][0] = poured;
		for (int i = 0; i < query_row; i++) {
			for (int j = 0; j <= i; j++) {
				double excess = (glasses[i][j] - 1) / 2;
				if (excess > 0) {
					glasses[i + 1][j] += excess;
					glasses[i + 1][j + 1] += excess;
				}
			}
		}
		return Math.min(1, glasses[query_row][query_glass]);
	}
}
