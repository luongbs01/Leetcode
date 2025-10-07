import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Description: https://leetcode.com/problems/avoid-flood-in-the-city/description/
 */

public class AvoidFloodInTheCity {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                if (map.containsKey(rains[i])) {
                    Integer ceiling = treeSet.ceiling(map.get(rains[i]));
                    if (ceiling == null) {
                        return new int[0];
                    }
                    ans[ceiling] = rains[i];
                    treeSet.remove(ceiling);
                }
                map.put(rains[i], i);
                ans[i] = -1;
            } else {
                treeSet.add(i);
            }
        }
        return ans;
    }
}
