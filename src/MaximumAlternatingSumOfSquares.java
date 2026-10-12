import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximum-alternating-sum-of-squares/
 */

public class MaximumAlternatingSumOfSquares {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i : nums) {
            list.add(i);
        }
        list.sort((o1, o2) -> Integer.compare(Math.abs(o1), Math.abs(o2)));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long) list.get(i) * list.get(i)) * (i < n / 2 ? -1 : 1);
        }
        return ans;
    }

    public long maxAlternatingSumV2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long) nums[i] * nums[i]) * (i < n / 2 ? -1 : 1);
        }
        return ans;
    }
}
