import java.util.*;

/**
 * Description: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
 */

public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        int[] dp = new int[n];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i] - difference, new ArrayList<>());
            for (int j : list) {
                if (j < i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public int longestSubsequenceV2(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int newValue = map.getOrDefault(i - difference, 0) + 1;
            map.put(i, newValue);
            ans = Math.max(ans, newValue);
        }
        return ans;
    }
}
