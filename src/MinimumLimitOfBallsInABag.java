import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/
 */

public class MinimumLimitOfBallsInABag {

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (canDivide(nums, maxOperations, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canDivide(int[] nums, int maxOperations, int max) {
        int cnt = 0;
        for (int num : nums) {
            cnt += (num - 1) / max;
        }
        return cnt <= maxOperations;
    }
}
