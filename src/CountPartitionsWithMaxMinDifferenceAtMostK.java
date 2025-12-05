import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/count-collisions-on-a-road/
 */

public class CountPartitionsWithMaxMinDifferenceAtMostK {

    public int countPartitions(int[] nums, int k) {
        int n = nums.length, mod = 1_000_000_007, left = 0;
        long[] dp = new long[n + 1]; // dp[i]: number of ways to split array of first i elements
        long[] prefixSum = new long[n + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dp[0] = 1;
        dp[1] = 1;
        prefixSum[0] = 1;
        prefixSum[1] = 2;
        map.put(nums[0], 1);
        for (int i = 2; i <= n; i++) {
            map.put(nums[i - 1], map.getOrDefault(nums[i - 1], 0) + 1);
            while (map.lastKey() - map.firstKey() > k) {
                int freq = map.get(nums[left]);
                if (freq > 1)
                    map.put(nums[left], freq - 1);
                else
                    map.remove(nums[left]);
                left++;
            }
            dp[i] = (prefixSum[i - 1] - (left > 0 ? prefixSum[left - 1] : 0) + mod) % mod;
            prefixSum[i] = (prefixSum[i - 1] + dp[i] + mod) % mod;
        }
        return (int) dp[n] % mod;
    }
}
