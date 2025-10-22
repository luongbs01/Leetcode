import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/
 */

public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = Arrays.stream(nums).max().getAsInt(), ans = 0, cnt = 0;
        int[] freq = new int[max + 1], count = new int[max + 1], countReversed = new int[max + 1];
        for (int i : nums) {
            freq[i]++;
        }
        for (int i = 0; i <= max; i++) {
            cnt += freq[i];
            count[i] = cnt;
        }
        cnt = 0;
        for (int i = max; i >= 0; i--) {
            cnt += freq[i];
            countReversed[i] = cnt;
        }
        for (int i = 0; i <= max; i++) {
            ans = Math.max(ans, freq[i] + Math.min(numOperations, count[Math.min(max, i + k)] - count[i] + countReversed[Math.max(0, i - k)] - countReversed[i]));
        }
        return ans;
    }
}
