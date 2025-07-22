import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/maximum-erasure-value/description/
 */

public class MaximumErasureValue {

    // 49ms
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, sum = 0;
        int ans = 0;
        for (int num : nums) {
            while (set.contains(num)) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(num);
            sum += num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // 5ms
    public int maximumUniqueSubarrayV2(int[] nums) {
        boolean[] marked = new boolean[10001];
        int left = 0, sum = 0;
        int ans = 0;
        for (int num : nums) {
            while (marked[num]) {
                marked[nums[left]] = false;
                sum -= nums[left];
                left++;
            }
            marked[num] = true;
            sum += num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
