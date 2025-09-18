import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
 */

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public int longestSubarray(int[] nums, int limit) {
        int ans = 0, l = 0, n = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int r = 0; r < n; r++) {
            treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[l], treeMap.get(nums[l]) - 1);
                if (treeMap.get(nums[l]) == 0) {
                    treeMap.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
