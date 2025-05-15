import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-consecutive-sequence/
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int ans = 0;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                int left = i, right = i;
                while (map.containsKey(left)) {
                    map.put(left, 2);
                    left--;
                }
                while (map.containsKey(right)) {
                    map.put(right, 2);
                    right++;
                }
                ans = Math.max(ans, right - left - 1);
            }
        }
        return ans;
    }
}
