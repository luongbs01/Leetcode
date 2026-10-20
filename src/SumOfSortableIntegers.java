/**
 * Description: https://leetcode.com/problems/sum-of-sortable-integers/
 */

public class SumOfSortableIntegers {

    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && check(nums, n, k)) {
                ans += k;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int n, int k) {
        int min, max, prevMax = -1;
        for (int i = 0; i < n; i += k) {
            int cnt = nums[i] < nums[i + k - 1] ? 1 : 0;
            min = nums[i];
            max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j - 1] > nums[j]) {
                    cnt++;
                }
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }
            if (cnt > 1 || prevMax > min) {
                return false;
            }
            prevMax = max;
        }
        return true;
    }
}
