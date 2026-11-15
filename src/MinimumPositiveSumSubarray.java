import java.util.List;

/**
 * Description: https://leetcode.com/problems/minimum-positive-sum-subarray/
 */

public class MinimumPositiveSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size(), minSum = Integer.MAX_VALUE;
        for (int size = l; size <= r; size++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + nums.get(i) - (i >= size ? nums.get(i - size) : 0);
                if (i + 1 >= size && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
