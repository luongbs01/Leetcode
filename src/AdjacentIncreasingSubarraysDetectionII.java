import java.util.List;

/**
 * Description: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/
 */

public class AdjacentIncreasingSubarraysDetectionII {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), ans = 1, count = 1, prevCount = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                count++;
            } else {
                prevCount = count;
                count = 1;
            }
            ans = Math.max(ans, Math.min(count, prevCount));
            ans = Math.max(ans, count / 2);
        }
        return ans;
    }
}
