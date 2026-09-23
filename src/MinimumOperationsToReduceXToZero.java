import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */

public class MinimumOperationsToReduceXToZero {

    // 49ms
    public int minOperations(int[] nums, int x) {
        int n = nums.length, prefixSum = 0, suffixSum = 0, ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>(n);
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (prefixSum == x)
                ans = (i + 1);
            map.put(prefixSum, i);
        }
        if (prefixSum < x)
            return -1;
        for (int i = n - 1; i >= 0 && suffixSum <= x; i--) {
            suffixSum += nums[i];
            Integer j = map.get(x - suffixSum);
            if (j != null) {
                ans = Math.min(ans, (j + 1) + (n - i));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 5ms
    public int minOperationsV2(int[] nums, int x) {
        int n = nums.length, sum = 0, maxLength = -1, l = 0, s = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum < x) {
            return -1;
        }
        for (int r = 0; r < n; r++) {
            s += nums[r];
            while (l <= r && s > sum - x) {
                s -= nums[l];
                l++;
            }
            if (s == sum - x) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength != -1 ? n - maxLength : -1;
    }
}
