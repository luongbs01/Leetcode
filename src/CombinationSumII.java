import java.util.*;

/**
 * Description: https://leetcode.com/problems/combination-sum-ii/
 */

public class CombinationSumII {
    List<List<Integer>> ans;
    TreeMap<Integer, Integer> freq = new TreeMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        for (int candidate : candidates) {
            if (candidate <= target) {
                freq.put(candidate, freq.getOrDefault(candidate, 0) + 1);
            }
        }
        backtrack(0, 0, new LinkedList<>(), freq.keySet().toArray(new Integer[0]), target);
        return ans;
    }

    private void backtrack(int index, int sum, LinkedList<Integer> list, Integer[] uniqueCandidates, int target) {
        if (sum >= target || index >= uniqueCandidates.length) {
            if (sum == target) {
                ans.add(new ArrayList<>(list));
            }
        } else {
            int min = Math.min(freq.get(uniqueCandidates[index]), (target - sum) / uniqueCandidates[index]);
            for (int i = 0; i <= min; i++) {
                for (int j = 0; j < i; j++) {
                    list.addLast(uniqueCandidates[index]);
                }
                backtrack(index + 1, sum + uniqueCandidates[index] * i, list, uniqueCandidates, target);
                for (int k = 0; k < i; k++) {
                    list.removeLast();
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2V2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(0, 0, new LinkedList<>(), candidates, target, ans);
        return ans;
    }

    private void backtrack(int fromIndex, int sum, LinkedList<Integer> list, int[] candidates, int target,
                           List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new LinkedList<>(list));
        } else {
            for (int i = fromIndex; i < candidates.length; i++) {
                if (i > fromIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (sum + candidates[i] > target) {
                    break;
                }
                list.addLast(candidates[i]);
                backtrack(i + 1, sum + candidates[i], list, candidates, target, ans);
                list.removeLast();
            }
        }
    }
}
