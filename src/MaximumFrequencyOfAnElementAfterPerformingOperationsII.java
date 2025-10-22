import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/
 */

public class MaximumFrequencyOfAnElementAfterPerformingOperationsII {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = Arrays.stream(nums).max().getAsInt(), ans = 0, cnt = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, Integer> count = new TreeMap<>(), countReversed = new TreeMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : freq.keySet().stream().sorted().toList()) {
            cnt += freq.get(i);
            count.put(i, cnt);
        }
        cnt = 0;
        for (int i : freq.keySet().stream().sorted().toList().reversed()) {
            cnt += freq.get(i);
            countReversed.put(i, cnt);
        }
        for (int i : nums) {
            ans =
                    Math.max(ans, freq.get(i) + Math.min(numOperations,
                            count.floorEntry(i + k).getValue() - count.get(i) + countReversed.ceilingEntry(Math.max(0, i - k)).getValue() - countReversed.get(i)));
            if (i + k <= max && countReversed.ceilingEntry(i + k) != null)
                ans = Math.max(ans,
                        freq.getOrDefault(i + k, 0) + Math.min(numOperations,
                                count.floorEntry(i + 2 * k).getValue() - count.floorEntry(i + k).getValue() + countReversed.get(i) - countReversed.ceilingEntry(i + k)
                                        .getValue()));
            if (i - k >= 0 && count.floorEntry(Math.max(0, i - k)) != null)
                ans = Math.max(ans, freq.getOrDefault(i - k, 0) + Math.min(numOperations,
                        count.get(i) - count.floorEntry(Math.max(0, i - k)).getValue() + countReversed.ceilingEntry(Math.max(0, i - 2 * k)).getValue()
                                - countReversed.ceilingEntry(Math.max(0, i - k)).getValue()));
        }
        return ans;
    }
}
