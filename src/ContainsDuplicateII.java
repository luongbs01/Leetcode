import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/contains-duplicate-ii/description/
 */

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = map.getOrDefault(nums[i], -1);
            if (val >= 0 && i - val <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
