import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description
 */

public class MinimizeTheMaximumDifferenceOfPairs {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        int maxDiff;
        while (l < r) {
            maxDiff = (l + r) >> 1;
            if (canFormPairsWithMaxDiff(nums, p, maxDiff)) {
                r = maxDiff;
            } else {
                l = maxDiff + 1;
            }
        }
        return r;
    }

    private boolean canFormPairsWithMaxDiff(int[] nums, int p, int maxDiff) {
        int r = 1;
        int cnt = 0;
        while (r < nums.length) {
            if (Math.abs(nums[r] - nums[r - 1]) <= maxDiff) {
                cnt++;
                r += 2;
            } else {
                r++;
            }
            if (cnt >= p) {
                return true;
            }
        }
        return false;
    }
}
