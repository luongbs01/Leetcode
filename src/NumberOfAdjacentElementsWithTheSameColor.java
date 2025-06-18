/**
 * Description: https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/description/
 */

public class NumberOfAdjacentElementsWithTheSameColor {

    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] ans = new int[queries.length];
        int cnt = 0;
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] - 1 >= 0) {
                cnt -= (colors[queries[i][0]] != 0 && colors[queries[i][0]] == colors[queries[i][0] - 1]) ? 1 : 0;
                cnt += (queries[i][1] == colors[queries[i][0] - 1]) ? 1 : 0;
            }
            if (queries[i][0] + 1 < n) {
                cnt -= (colors[queries[i][0]] != 0 && colors[queries[i][0]] == colors[queries[i][0] + 1]) ? 1 : 0;
                cnt += (queries[i][1] == colors[queries[i][0] + 1]) ? 1 : 0;
            }
            colors[queries[i][0]] = queries[i][1];
            ans[i] = cnt;
        }
        return ans;
    }
}
