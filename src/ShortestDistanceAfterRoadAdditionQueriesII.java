import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-ii/description/
 */

public class ShortestDistanceAfterRoadAdditionQueriesII {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int length = queries.length;
        Set<Integer> set = new HashSet<>(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            if (set.contains(queries[i][0]) && set.contains(queries[i][1])) {
                for (int j = map.getOrDefault(queries[i][0], queries[i][0] + 1); j < queries[i][1]; j++) {
                    set.remove(j);
                }
                map.put(queries[i][0], Math.max(map.getOrDefault(queries[i][0], 0), queries[i][1]));
            }
            ans[i] = set.size() - 1;
        }
        return ans;
    }
}
