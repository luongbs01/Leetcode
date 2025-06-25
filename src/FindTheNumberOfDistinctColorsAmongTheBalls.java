import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/
 */

public class FindTheNumberOfDistinctColorsAmongTheBalls {

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer, Integer> colors = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int oldColor = colors.getOrDefault(queries[i][0], 0);
            if (oldColor > 0) {
                if (cnt.get(oldColor) > 1) {
                    cnt.put(oldColor, cnt.get(oldColor) - 1);
                } else {
                    cnt.remove(oldColor);
                }
            }
            colors.put(queries[i][0], queries[i][1]);
            cnt.put(queries[i][1], cnt.getOrDefault(queries[i][1], 0) + 1);
            ans[i] = cnt.size();
        }
        return ans;
    }
}
