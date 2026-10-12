import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-target-indices-after-sorting-array/
 */

public class FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;
    }
}
