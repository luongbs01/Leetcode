/**
 * Description: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/
 */

public class FindTheMaximumLengthOfValidSubsequenceI {

    public int maximumLength(int[] nums) {
        int even = 0;
        int interleave = 0;
        int i = nums[0] % 2;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            }
            if (num % 2 == i) {
                interleave++;
                i = 1 - i;
            }
        }
        return Math.max(interleave, Math.max(even, nums.length - even));
    }
}
