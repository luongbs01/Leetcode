import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: https://leetcode.com/problems/rank-transform-of-an-array/
 */

public class RankTransformOfAnArray {

	public int[] arrayRankTransform(int[] arr) {
		int n = arr.length, rank = 1;
		if (n == 0) return arr;
		int[][] sortedArr = new int[n][2];
		for (int i = 0; i < n; i++) {
			sortedArr[i] = new int[] { arr[i], i };
		}
		Arrays.sort(sortedArr, Comparator.comparingInt(o -> o[0]));
		int[] ans = new int[n];
		ans[sortedArr[0][1]] = rank;
		for (int i = 1; i < n; i++) {
			if (sortedArr[i][0] > sortedArr[i - 1][0]) {
				rank++;
			}
			ans[sortedArr[i][1]] = rank;
		}
		return ans;
	}
}
