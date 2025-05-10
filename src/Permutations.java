import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/permutations/
 */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(new LinkedList<>(), new boolean[nums.length], nums, ans);
        return ans;
    }

    private void backtrack(LinkedList<Integer> list, boolean[] marked, int[] nums, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new LinkedList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!marked[i]) {
                    marked[i] = true;
                    list.add(nums[i]);
                    backtrack(list, marked, nums, ans);
                    list.removeLast();
                    marked[i] = false;
                }
            }
        }
    }
}

