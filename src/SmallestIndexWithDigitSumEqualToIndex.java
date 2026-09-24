/**
 * Description: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
 */

public class SmallestIndexWithDigitSumEqualToIndex {

    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = nums[i]; j > 0; j /= 10) {
                sum += j % 10;
            }
            if (sum == i)
                return i;
        }
        return -1;
    }
}
