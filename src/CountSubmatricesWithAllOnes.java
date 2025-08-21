/**
 * Description: https://leetcode.com/problems/count-submatrices-with-all-ones/description/
 */

public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int n = mat[0].length, ans = 0;
        int[] height = new int[n];
        for (int[] row : mat) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    height[j] = 0;
                } else {
                    height[j]++;
                    int minHeight = height[j];
                    for (int k = j; k >= 0 && minHeight > 0; k--) {
                        minHeight = Math.min(minHeight, height[k]);
                        ans += minHeight;
                    }
                }
            }
        }
        return ans;
    }
}
