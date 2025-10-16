/**
 * Description: https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
 */

public class SmallestMissingNonNegativeIntegerAfterOperations {

    public int findSmallestInteger(int[] nums, int value) {
        int minFreq = Integer.MAX_VALUE, minIndex = 0;
        int[] freq = new int[value];
        for (int i : nums) {
            freq[((i % value) + value) % value]++;
        }
        for (int i = 0; i < value; i++) {
            if (minFreq > freq[i]) {
                minFreq = freq[i];
                minIndex = i;
            }
            if (minFreq == 0)
                break;
        }
        return value * minFreq + minIndex;
    }
}
