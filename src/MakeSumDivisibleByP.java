import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/make-sum-divisible-by-p/description/
 */

public class MakeSumDivisibleByP {

    // 44ms
    public int minSubarray(int[] nums, int p) {
        Map<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        int n = nums.length, ans = n, prefixSum = 0;
        map.computeIfAbsent(0, (_ -> new ArrayDeque<>())).offer(n);
        for (int i = n - 1; i >= 0; i--) {
            prefixSum = (prefixSum + nums[i] % p) % p;
            map.computeIfAbsent(prefixSum, _ -> new ArrayDeque<>()).push(i);
        }
        prefixSum = 0;
        for (int i = 0; i < n; i++) {
            int mod = (p - prefixSum) % p;
            prefixSum = (prefixSum + nums[i] % p) % p;
            ArrayDeque<Integer> stack = map.get(mod);
            if (stack == null || stack.isEmpty()) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < i) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans = Math.min(ans, stack.peek() - i);
            }
        }
        return ans == n ? -1 : ans;
    }

    // 28ms
    public int minSubarrayV2(int[] nums, int p) {
        int n = nums.length, remainder = 0, prefixSum = 0, ans = n;
        for (int i : nums) {
            remainder = (remainder + i % p) % p;
        }
        if (remainder == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i] % p) % p;
            int need = (prefixSum - remainder + p) % p;
            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }
            map.put(prefixSum, i);
        }
        return ans == n ? -1 : ans;
    }
}
