import java.util.*;

/**
 * Description: http://leetcode.com/problems/3sum/description/
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, Boolean> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int p = 0; p < length - 2; p++) {
            int sum = nums[p];
            int i = p + 1, j = length - 1;
            while (i < j) {
                if (nums[i] + nums[j] + sum > 0) {
                    j--;
                } else if (nums[i] + nums[j] + sum < 0) {
                    i++;
                } else {
                    String key = Arrays.toString(new int[]{sum, nums[i], nums[j]});
                    if (!map.containsKey(key)) {
                        map.put(key, true);
                        ans.add(List.of(nums[i], nums[j], sum));
                    }
                    i++;
                    j--;

                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                }
            }
        }
        return ans;
    }
}
