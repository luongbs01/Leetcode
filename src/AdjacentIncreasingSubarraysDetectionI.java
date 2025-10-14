import java.util.List;

/**
 * Description: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/
 */

public class AdjacentIncreasingSubarraysDetectionI {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i < n - 2 * k + 1; i++) {
            boolean found = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1) || nums.get(j + k) >= nums.get(j + k + 1)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return found;
            }
        }
        return false;
    }
}
