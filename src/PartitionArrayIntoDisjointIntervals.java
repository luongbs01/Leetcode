/**
 * Description: https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */

public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length, rightMin = nums[n - 1], ans = n;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        for (int i = n - 1; i >= 1; i--) {
            rightMin = Math.min(rightMin, nums[i]);
            if (leftMax[i - 1] <= rightMin) {
                ans = i;
            }
        }
        return ans;
    }
}
