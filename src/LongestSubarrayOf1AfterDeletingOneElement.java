import java.util.ArrayList;

/**
 * Description: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class LongestSubarrayOf1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0, len = nums.length;
        boolean hasZero = false;
        if (nums[0] == 1) count++;
        for (int i = 1; i < len; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                hasZero = true;
            }
            if ((nums[i - 1] == 1 && nums[i] == 0) || ((i == len - 1) && (nums[i] == 1))) {
                arr.add(count);
                count = 0;
            } else if ((nums[i - 1] == 0 && nums[i] == 0)) {
                arr.add(0);
            }
        }
        len = arr.size();
        if (len == 1) return hasZero ? arr.get(0) : arr.get(0) - 1;
        int sum = arr.get(0) + arr.get(1);
        int max = sum;
        for (int i = 1; i < len - 1; i++) {
            sum = sum + arr.get(i + 1) - arr.get(i - 1);
            max = sum > max ? sum : max;
        }
        return max;
    }
}
