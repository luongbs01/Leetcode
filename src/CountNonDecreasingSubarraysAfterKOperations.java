import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
 */

public class CountNonDecreasingSubarraysAfterKOperations {

    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, maxIndex = 0;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int[] nextLte = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && nums[i] >= nums[stack.peek()]) {
                nextLte[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int idx = stack.pop();
            nextLte[idx] = idx;
        }
        System.out.println(Arrays.toString(prefixSum));
        System.out.println(Arrays.toString(nextLte));

        long invalidCnt = 0, operation = 0;
        while (r < n) {
            while (operation <= k && r < n) {
                if (nums[r] < nums[maxIndex]) {
                    operation += nums[maxIndex] - nums[r];
                } else {
                    maxIndex = r;
                }
                r++;
            }
            invalidCnt += (n - r);
            if (l < r && nums[l + 1] < nums[l]) {
                operation = operation
                        - ((long) nums[l] * (nextLte[l] - l) - (prefixSum[nextLte[l]] - prefixSum[l]))
                        + ((long) nums[l + 1] * (nextLte[l + 1] - (l + 1))
                        - (prefixSum[nextLte[l + 1]] - prefixSum[l + 1]));
            }
            l++;
            maxIndex = Math.max(maxIndex, l);
        }
        return (long) n * (n + 1) / 2 - invalidCnt;
    }
}
