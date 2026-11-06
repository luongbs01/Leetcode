import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/count-zero-request-servers/description/
 */

public class CountZeroRequestServers {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length, l = 0, r = 0;
        int[] ans = new int[queries.length];
        Map<Integer, Queue<Integer>> queryToIndex = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            queryToIndex.computeIfAbsent(queries[i], _ -> new ArrayDeque<>()).offer(i);
        }
        Arrays.sort(queries);
        Arrays.sort(logs, Comparator.comparingInt(o -> o[1]));
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int query : queries) {
            while (r < m && logs[r][1] <= query) {
                cnt.put(logs[r][0], cnt.getOrDefault(logs[r][0], 0) + 1);
                r++;
            }
            while (l < m && l <= r && logs[l][1] < query - x) {
                cnt.put(logs[l][0], cnt.get(logs[l][0]) - 1);
                if (cnt.get(logs[l][0]) == 0) {
                    cnt.remove(logs[l][0]);
                }
                l++;
            }
            ans[queryToIndex.get(query).poll()] = n - cnt.size();
        }
        return ans;
    }
}
