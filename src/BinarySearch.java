/**
 * Description: https://leetcode.com/problems/min-stack/description/
 */

public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int num, index;
        while (low <= high) {
            index = low + (high - low) / 2;
            num = nums[index];
            if (num == target) {
                return index;
            } else if (num < target) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        return -1;
    }
}
