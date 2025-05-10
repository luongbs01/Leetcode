import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/subsets/description/
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int[] flag = new int[nums.length];
        backtrack(0, flag, nums, ans);
        return ans;
    }

    private void backtrack(int i, int[] flag, int[] nums, List<List<Integer>> ans) {
        if (i == flag.length) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < flag.length; j++) {
                if (flag[j] > 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        } else {
            for (int j = 0; j < 2; j++) {
                flag[i] = j;
                backtrack(i + 1, flag, nums, ans);
            }
        }
    }
}
