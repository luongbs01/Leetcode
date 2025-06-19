import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/
 */

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                ans++;
                min = num;
            }
        }
        return ans;
    }
}
