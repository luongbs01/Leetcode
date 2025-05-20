/**
 * Description: https://leetcode.com/problems/product-of-array-except-self/description/
 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = nums[0];
        suffix[length - 1] = nums[length - 1];
        for (int i = 1; i < length - 1; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[length - 1 - i] = suffix[length - i] * nums[length - i - 1];
        }
        nums[0] = suffix[1];
        nums[length - 1] = prefix[length - 2];
        for (int i = 1; i < length - 1; i++) {
            nums[i] = prefix[i - 1] * suffix[i + 1];
        }
        return nums;
    }
}
