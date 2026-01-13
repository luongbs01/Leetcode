/**
 * Description: https://leetcode.com/problems/separate-squares-i/description/
 */

public class SeparateSquaresI {

	public double separateSquares(int[][] squares) {
		double l = Double.MAX_VALUE, h = 0;
		for (int[] square : squares) {
			l = Math.min(l, square[1]);
			h = Math.max(h, square[1] + square[2]);
		}
		while (h - l >= 0.00001) {
			double mid = (h + l) / 2;
			int cmp = compare(squares, mid);
			if (cmp <= 0) {
				h = mid;
			} else {
				l = mid;
			}
		}
		return h;
	}

	private int compare(int[][] squares, double mid) {
		double a = 0, b = 0; // total area above and below the line y = mid
		for (int[] square : squares) {
			if (square[1] >= mid) {
				a += (double) square[2] * square[2];
			} else if (square[1] + square[2] <= mid) {
				b += (double) square[2] * square[2];
			} else {
				a += (double) square[2] * (square[1] + square[2] - mid);
				b += (double) square[2] * (mid - square[1]);
			}
		}
		return Double.compare(a, b);
	}
}
