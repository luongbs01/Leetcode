import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/combination-sum/
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(0, 0, new LinkedList<>(), candidates, target, ans);
        return ans;
    }

    private void backtrack(int fromIndex, int sum, LinkedList<Integer> list, int[] candidates, int target, List<List<Integer>> ans) {
        if (sum >= target) {
            if (sum == target) {
                ans.add(Arrays.asList(list.toArray(new Integer[]{})));
            }
        } else {
            for (int i = fromIndex; i < candidates.length; i++) {
                list.addLast(candidates[i]);
                backtrack(i, sum + candidates[i], list, candidates, target, ans);
                list.removeLast();
            }
        }
    }
}
