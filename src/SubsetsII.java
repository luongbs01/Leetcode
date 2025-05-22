import java.util.*;

/**
 * Description: https://leetcode.com/problems/subsets-ii/
 */

public class SubsetsII {

    List<List<Integer>> ans;
    HashSet<String> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, new LinkedList<>(), nums);
        return ans;
    }

    private void backtrack(int i, LinkedList<Integer> list, int[] nums) {
        if (i == nums.length) {
            String key = Arrays.toString(list.toArray());
            if (!set.contains(key)) {
                ans.add(new LinkedList<>(list));
                set.add(key);
            }
        } else {
            backtrack(i + 1, list, nums);
            list.add(nums[i]);
            backtrack(i + 1, list, nums);
            list.removeLast();
        }
    }
}
