/**
 * Description: http://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int low = 0, high = length - 1, mid = 0;
        int minIndex = findMinIndex(nums);
        int maxIndex = minIndex == 0 ? high : minIndex - 1;
        int min = nums[minIndex], max = nums[maxIndex];
        if (target < min || target > max) {
            return -1;
        } else if (target <= nums[high]) {
            low = minIndex;
        } else if (target >= nums[low]) {
            high = maxIndex;
        }
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[mid] == target ? mid : -1;
    }

    public int findMinIndex(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            if (nums[low] <= nums[high]) return low;
            mid = (low + high) >>> 1;
            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return mid;
    }
}
