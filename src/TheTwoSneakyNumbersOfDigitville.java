/**
 * Description: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
 */

public class TheTwoSneakyNumbersOfDigitville {

    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[nums.length - 2], ans = new int[2];
        for (int i : nums) {
            freq[i]++;
        }
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                ans[index] = i;
                index++;
            }
        }
        return ans;
    }
}
