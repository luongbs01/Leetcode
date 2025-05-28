/**
 * Description: https://leetcode.com/problems/search-insert-position/description/
 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0]) return 0;
        if (target > nums[n - 1]) return n;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
