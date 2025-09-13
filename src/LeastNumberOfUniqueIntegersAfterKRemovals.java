import java.util.HashMap;

/**
 * Description: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
 */

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        k = arr.length - k;
        int ans = 0;
        for (int val : map.values().stream().sorted((o1, o2) -> o2 - o1).toList()) {
            if (k > 0) {
                k -= val;
                ans++;
            }
        }
        return ans;
    }
}
