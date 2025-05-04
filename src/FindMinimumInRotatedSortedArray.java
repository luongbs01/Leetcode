/**
 * Description: http://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            if (nums[low] <= nums[high]) return nums[low];
            mid = (low + high) >>> 1;
            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[mid];
    }
}
