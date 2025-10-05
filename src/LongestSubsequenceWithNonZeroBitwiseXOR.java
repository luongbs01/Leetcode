/**
 * Description: https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/description/
 */

public class LongestSubsequenceWithNonZeroBitwiseXOR {

    public int longestSubsequence(int[] nums) {
        int n = nums.length, xor = 0;
        boolean hasPositive = false;
        for (int num : nums) {
            xor ^= num;
            if (num > 0) hasPositive = true;
        }
        return xor > 0 ? n : hasPositive ? n - 1 : 0;
    }
}
